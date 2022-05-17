package com.IshanAdeepaRidma.BidCoinBackend.Bids;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "BidsEntered")
public class SingleBidModel {
    @Id
    @Column(length = 30)
    private String email;
    @Column
    private LocalDateTime bidEnteredTime;
    @Column
    private String cryptoName;
    @Column
    private Double bidValue;

    public SingleBidModel() {

    }

    public SingleBidModel(String email, LocalDateTime bidEnteredTime, String cryptoName,
            Double bidValue) {
        this.email = email;
        this.bidEnteredTime = bidEnteredTime;
        this.cryptoName = cryptoName;
        this.bidValue = bidValue;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBidEnteredTime() {
        return this.bidEnteredTime;
    }

    public void setBidEnteredTime(LocalDateTime bidEnteredTime) {
        this.bidEnteredTime = bidEnteredTime;
    }

    public String getCryptoName() {
        return this.cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public Double getBidValue() {
        return this.bidValue;
    }

    public void setBidValue(Double bidValue) {
        this.bidValue = bidValue;
    }

}
