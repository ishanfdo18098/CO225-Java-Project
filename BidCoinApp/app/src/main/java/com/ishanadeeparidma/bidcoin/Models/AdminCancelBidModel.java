package com.ishanadeeparidma.bidcoin.Models;

public class AdminCancelBidModel {
    private String cryptoName;
    private String whoWonTheBid;
    private Double bidWonPrice;

    public AdminCancelBidModel(String cryptoName, String whoWonTheBid, Double bidWonPrice) {
        this.cryptoName = cryptoName;
        this.whoWonTheBid = whoWonTheBid;
        this.bidWonPrice = bidWonPrice;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public String getWhoWonTheBid() {
        return whoWonTheBid;
    }

    public void setWhoWonTheBid(String whoWonTheBid) {
        this.whoWonTheBid = whoWonTheBid;
    }

    public Double getBidWonPrice() {
        return bidWonPrice;
    }

    public void setBidWonPrice(Double bidWonPrice) {
        this.bidWonPrice = bidWonPrice;
    }
}
