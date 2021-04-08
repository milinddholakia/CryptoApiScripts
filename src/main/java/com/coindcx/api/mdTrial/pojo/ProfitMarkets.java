package com.coindcx.api.mdTrial.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROFITMARKET")
public class ProfitMarkets {
    @Id
    @Column(name = "MARKET")
    private String market;

    @Column(name = "PERCENTAGEGROWTH")
    private Float percentageGrowth;


    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }


    public Float getPercentageGrowth() {
        return percentageGrowth;
    }

    public void setPercentageGrowth(Float percentageGrowth) {
        this.percentageGrowth = percentageGrowth;
    }

}
