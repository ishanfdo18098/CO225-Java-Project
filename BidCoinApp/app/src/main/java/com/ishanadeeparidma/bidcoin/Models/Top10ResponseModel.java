package com.ishanadeeparidma.bidcoin.Models;

public class Top10ResponseModel {
    private String name;
    private String symbol;
    private Double priceInUSD;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPriceInUSD() {
        return priceInUSD;
    }

    public void setPriceInUSD(Double priceInUSD) {
        this.priceInUSD = priceInUSD;
    }
}
