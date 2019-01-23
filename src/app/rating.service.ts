import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { RatingVO } from '../app/ratingVO';
@Injectable({
  providedIn: 'root'
})
export class RatingService {

  /*REST END Point URLs
  1.Get Average Rating -- GET Mapping
  2.Submit Current user Rating -- POST Mapping
  */

  GET_AVGRATING_URL = 'http://localhost:8080/d3op/getrating/';
  SUBMIT_RATING_URL = 'http://localhost:8080/d3op/postrating/';


  constructor(private _httpclient: HttpClient) {
  }


  getRating(laptopname): Observable<any> {
    console.log('laptopname===>' + laptopname);
    console.log('inside service...' + this.GET_AVGRATING_URL + laptopname);
    return this._httpclient.get(this.GET_AVGRATING_URL + laptopname);
  }

  postRating(ratingdet: RatingVO): Observable<any>  {
    console.log('inside service.......' + ratingdet.currentRating + '::' + ratingdet.laptopName);
    return this._httpclient.post(this.SUBMIT_RATING_URL, ratingdet);
  }
}
