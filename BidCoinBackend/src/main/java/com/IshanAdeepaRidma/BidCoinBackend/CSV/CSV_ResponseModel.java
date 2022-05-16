package com.IshanAdeepaRidma.BidCoinBackend.CSV;

public class CSV_ResponseModel {
    private String symbol;
    private String name;
    private Integer rank;

    public CSV_ResponseModel(String symbol, String name, Integer rank) {
        this.symbol = symbol;
        this.name = name;
        this.rank = rank;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRank() {
        return this.rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
