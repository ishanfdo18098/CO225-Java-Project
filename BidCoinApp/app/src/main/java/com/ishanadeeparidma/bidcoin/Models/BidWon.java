package com.ishanadeeparidma.bidcoin.Models;

import java.time.LocalDateTime;

public class BidWon {
    private String email;
    private String cryptoName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double bidWonValue;

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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getBidWonValue() {
        return bidWonValue;
    }

    public void setBidWonValue(Double bidWonValue) {
        this.bidWonValue = bidWonValue;
    }


}
