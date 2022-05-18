package com.IshanAdeepaRidma.BidCoinBackend.CryptoAPI;

public class CryptoPriceModel {
    private String cryptoName;
    private Double priceInUSD;

    public CryptoPriceModel(String cryptoName, Double priceInUSD) {
        this.cryptoName = cryptoName;
        this.priceInUSD = priceInUSD;
    }

    public String getCryptoName() {
        return this.cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public Double getPriceInUSD() {
        return this.priceInUSD;
    }

    public void setPriceInUSD(Double priceInUSD) {
        this.priceInUSD = priceInUSD;
    }
}
