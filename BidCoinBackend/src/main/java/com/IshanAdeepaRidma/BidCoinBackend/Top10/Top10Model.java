package com.IshanAdeepaRidma.BidCoinBackend.Top10;

public class Top10Model {
    private String name;
    private String symbol;
    private Double priceInUSD;

    public Top10Model(String name, String symbol, Double priceInUSD){
        this.name = name;
        this.symbol = symbol;
        this.priceInUSD = priceInUSD;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPriceInUSD() {
        return this.priceInUSD;
    }

    public void setPriceInUSD(Double priceInUSD) {
        this.priceInUSD = priceInUSD;
    }


}
