package com.coindcx.api.mdTrial.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOSSMARKET")

public class LossMarkets {
    @Id
    @Column(name = "MARKET")
    private String market;

    @Column(name = "PERCENTAGELOSS")
    private Float percentageLoss;


    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }


    public Float getPercentageLoss() {
        return percentageLoss;
    }

    public void setPercentageLoss(Float percentageLoss) {
        this.percentageLoss = percentageLoss;
    }

}
