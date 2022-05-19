package com.ishanadeeparidma.bidcoin.Models;

import java.time.LocalDateTime;

public class WonBidsModel {
    private String email;
    private String cryptoName;
    private String startTime;
    private String endTime;
    private Double bidWonValue;

    public WonBidsModel(String email, String cryptoName, String startTime, String endTime, Double bidWonValue) {
        this.email = email;
        this.cryptoName = cryptoName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bidWonValue = bidWonValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getBidWonValue() {
        return bidWonValue;
    }

    public void setBidWonValue(Double bidWonValue) {
        this.bidWonValue = bidWonValue;
    }
}
