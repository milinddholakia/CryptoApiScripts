package com.coindcx.api.mdTrial.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LossMarkets")

public class LossMarkets {
@Id
@Column(name = "MARKET")
private String market;

  @Column(name = "PERCENTAGELOSS")
  private double percentageLoss;


  public String getMarket() {
    return market;
  }

  public void setMarket(String market) {
    this.market = market;
  }


  public double getPercentageLoss() {
    return percentageLoss;
  }

  public void setPercentageLoss(double percentageLoss) {
    this.percentageLoss = percentageLoss;
  }

}
