package com.D3OP.rating.d3oplaptoprating.services;

import com.D3OP.rating.d3oplaptoprating.model.RatingVO;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/d3op")
public class RatingService {

  private List<RatingVO> ratings = new ArrayList<>(
      Arrays.asList(
          new RatingVO("MacBookPro2018", 0, 0, 0,0),
          new RatingVO("GooglePixelbook", 0, 0, 0,0),
          new RatingVO("AsusZenbook", 0, 0, 0,0)
      )
  );

  @GetMapping("/getrating/{laptopname}")
  public int getAVGRating(@PathVariable("laptopname") String laptopname) {
    System.out.println("Get rating for LapTop Name:" + laptopname);
   // int rating = 0;
    int finalAvgRating =0 ;
    for (int i=0 ;i<ratings.size();i++) {
      if (ratings.get(i).getLaptopName().equalsIgnoreCase(laptopname)) {
        finalAvgRating=ratings.get(i).getAvgRating();
      }
    }
    return finalAvgRating;
  }

  @PostMapping("/postrating")
  public void postLaptopRating(@RequestBody RatingVO ratingVO) {
    System.out.println("Posting for LapTop Name:" + ratingVO.toString());
    String laptopname =ratingVO.getLaptopName() ;
    int finalAvgRating =0 ;
    for (int i=0 ;i<ratings.size();i++) {
      if (ratings.get(i).getLaptopName().equalsIgnoreCase(laptopname)) {
        System.out.println("Matching III==" +i);
        String laptopName = ratings.get(i).getLaptopName();
        int subCount = ratings.get(i).getSubNum();
        int avgRating = ratings.get(i).getAvgRating();
        int totalRating = ratings.get(i).getTotalRating();
        int currentRating = ratingVO.getCurrentRating();
        RatingVO voOBJ = new RatingVO();
        voOBJ.setLaptopName(laptopName);
        voOBJ.setSubNum(subCount + 1);
        System.out.println(totalRating+currentRating);
        voOBJ.setTotalRating(totalRating + currentRating);
        voOBJ.setCurrentRating(currentRating);
        voOBJ.setAvgRating(voOBJ.getTotalRating() / voOBJ.getSubNum());
        finalAvgRating = voOBJ.getAvgRating();
        ratings.set(i, voOBJ);
      }
    }
    System.out.println("Final List MAC==" +ratings.get(0).toString());
    System.out.println("Final List Google==" +ratings.get(1).toString());
    System.out.println("Final List ASUS==" +ratings.get(2).toString());
  }

}
