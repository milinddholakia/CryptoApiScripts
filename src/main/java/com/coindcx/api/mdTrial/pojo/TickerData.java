package com.coindcx.api.mdTrial.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TICKERDATA")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerData {
    @Id
    @JsonProperty("market")
    @Column(name = "MARKET")
    private String market;

    public String getMarket() {
        return this.market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @JsonProperty("change_24_hour")
    @Column(name = "CHANGE_24_HOUR")
    private String change_24_hour;

    public String getChange_24_hour() {
        return this.change_24_hour;
    }

    public void setChange_24_hour(String change_24_hour) {
        this.change_24_hour = change_24_hour;
    }

    @JsonProperty("high")
    @Column(name = "HIGH")
    private String high;

    public String getHigh() {
        return this.high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    @JsonProperty("low")
    @Column(name = "LOW")
    private String low;

    public String getLow() {
        return this.low;
    }

    public void setLow(String low) {
        this.low = low;
    }


    @JsonProperty("volume")
    @Column(name = "VOLUME")
    private String volume;

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }


    @JsonProperty("last_price")
    @Column(name = "LAST_PRICE")
    private String last_price;

    public String getLast_price() {
        return this.last_price;
    }

    public void setLast_price(String last_price) {
        this.last_price = last_price;
    }


    @JsonProperty("bid")
    @Column(name = "BID")
    private String bid;

    public String getBid() {
        return this.bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @JsonProperty("ask")
    @Column(name = "ASK")
    private String ask;

    public String getAsk() {
        return this.ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }


    @JsonProperty("timestamp")
    @Column(name = "TIMESTAMP")
    private Integer timestamp;

    public Integer getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

}



