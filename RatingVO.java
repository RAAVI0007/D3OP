package com.D3OP.rating.d3oplaptoprating.model;

public class RatingVO {
  private String laptopName;
  private int currentRating;
  private int avgRating;
  private int subNum;
  private int totalRating ;

  public RatingVO() {
  }

  public RatingVO(String laptopName, int currentRating, int avgRating, int subNum, int totalRating) {
    this.laptopName = laptopName;
    this.currentRating = currentRating;
    this.avgRating = avgRating;
    this.subNum = subNum;
    this.totalRating = totalRating;
  }

  public String getLaptopName() {
    return laptopName;
  }

  public void setLaptopName(String laptopName) {
    this.laptopName = laptopName;
  }

  public int getCurrentRating() {
    return currentRating;
  }

  public void setCurrentRating(int currentRating) {
    this.currentRating = currentRating;
  }

  public int getAvgRating() {
    return avgRating;
  }

  public void setAvgRating(int avgRating) {
    this.avgRating = avgRating;
  }

  public int getSubNum() {
    return subNum;
  }

  public void setSubNum(int subNum) {
    this.subNum = subNum;
  }

  public int getTotalRating() {
    return totalRating;
  }

  public void setTotalRating(int totalRating) {
    this.totalRating = totalRating;
  }

  @Override
  public String toString() {
    return "RatingVO{" +
        "laptopName='" + laptopName + '\'' +
        ", currentRating=" + currentRating +
        ", avgRating=" + avgRating +
        ", subNum=" + subNum +
        ", totalRating=" + totalRating +
        '}';
  }
}
