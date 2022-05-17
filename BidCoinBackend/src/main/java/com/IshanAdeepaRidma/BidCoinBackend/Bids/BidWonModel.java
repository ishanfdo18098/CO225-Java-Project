package com.IshanAdeepaRidma.BidCoinBackend.Bids;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "bidsWon")
public class BidWonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String email;
    @Column
    private String cryptoName;
    @Column
    private LocalDateTime startTime;
    @Column
    private LocalDateTime endTime;
    @Column
    private Double bidWonValue;

    public BidWonModel() {

    }

    public BidWonModel(String email, String cryptoName, LocalDateTime startTime, LocalDateTime endTime,
            Double bidWonValue) {
        this.email = email;
        this.cryptoName = cryptoName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bidWonValue = bidWonValue;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCryptoName() {
        return this.cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getBidWonValue() {
        return this.bidWonValue;
    }

    public void setBidWonValue(Double bidWonValue) {
        this.bidWonValue = bidWonValue;
    }

}
