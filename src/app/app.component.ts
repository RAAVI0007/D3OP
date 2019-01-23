import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, FormArray, NgForm } from '@angular/forms';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { RatingService } from '../app/rating.service';
import { RatingVO } from '../app/ratingVO';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'D3OP-Rating';
  readonly = false;
  ratingForm: FormGroup;
  selectedLapTop = '';
  selectedImage = '';
  ratingHidden = true;
  ratingSubmitted = true;
  currentRate = 0;
  avgRating;
  form: any = {};
  private ratinginfo: RatingVO;

  laptops = [
    { 'id': 1, 'name': 'MacBookPro2018' },
    { 'id': 2, 'name': 'AsusZenbook' },
    { 'id': 3, 'name': 'GooglePixelbook' }
  ];




  constructor(
    private formBuilder: FormBuilder,
    private _http: HttpClient,
    private ratingService: RatingService) {
  }


  ngOnInit() {
    this.ratingForm = this.formBuilder.group({
      laptopname: ['', Validators.required]
    });
  }


  modelSelected(event): void {

    this.ratingHidden = false;
    this.selectedLapTop = event.target.value;

    if (this.selectedLapTop === 'MacBookPro2018') {
      this.selectedImage = '../assets/macbookPro.jpg';
    }

    if (this.selectedLapTop === 'AsusZenbook') {
      this.selectedImage = '../assets/asus.jpg';
    }

    if (this.selectedLapTop === 'GooglePixelbook') {
      this.selectedImage = '../assets/googlePixel.jpg';
    }
  }


  getAvgRating() {
    this.ratingService.getRating(this.selectedLapTop).subscribe(
      data => {
        this.avgRating = data;
      }
    );
  }

  submitRating() {
    this.ratinginfo = new RatingVO(
      this.form.laptopname = this.selectedLapTop,
      this.form.currentRating = this.currentRate
    );
    this.ratingService.postRating(this.ratinginfo).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
    /*this.getAvgRating(this.selectedLapTop);*/
    console.log('ratings by current user::' + this.currentRate);
  }




}
