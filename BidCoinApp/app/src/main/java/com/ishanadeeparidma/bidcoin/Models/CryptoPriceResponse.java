package com.ishanadeeparidma.bidcoin.Models;

public class CryptoPriceResponse {
    private String cryptoName;
    private Double priceInUSD;

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public Double getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(Double priceInUSD) {
        this.priceInUSD = priceInUSD;
    }
}
