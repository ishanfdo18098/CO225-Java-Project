package com.IshanAdeepaRidma.BidCoinBackend.AdminMode;

public class BidCancelModel {
    private String cryptoName;
    private String whoWonTheBid;
    private Double bidWonPrice;

    public BidCancelModel(String cryptoName, String whoWonTheBid, Double bidWonPrice) {
        this.cryptoName = cryptoName;
        this.whoWonTheBid = whoWonTheBid;
        this.bidWonPrice = bidWonPrice;
    }

    public String getCryptoName() {
        return this.cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public String getWhoWonTheBid() {
        return this.whoWonTheBid;
    }

    public void setWhoWonTheBid(String whoWonTheBid) {
        this.whoWonTheBid = whoWonTheBid;
    }

    public Double getBidWonPrice() {
        return this.bidWonPrice;
    }

    public void setBidWonPrice(Double bidWonPrice) {
        this.bidWonPrice = bidWonPrice;
    }

}
