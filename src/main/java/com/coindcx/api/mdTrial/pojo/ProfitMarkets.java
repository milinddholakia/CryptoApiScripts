package com.coindcx.api.mdTrial.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProfitMarkets")
public class ProfitMarkets {
@Id
@Column(name = "MARKET")
  private String market;

  @Column(name = "PERCENTAGEGROWTH")
  private double percentageGrowth;


  public String getMarket() {
    return market;
  }

  public void setMarket(String market) {
    this.market = market;
  }


  public double getPercentageGrowth() {
    return percentageGrowth;
  }

  public void setPercentageGrowth(double percentageGrowth) {
    this.percentageGrowth = percentageGrowth;
  }

}
