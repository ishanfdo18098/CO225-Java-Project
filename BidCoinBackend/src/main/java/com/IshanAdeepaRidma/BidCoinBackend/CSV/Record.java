package com.IshanAdeepaRidma.BidCoinBackend.CSV;

public class Record {
    String Symbol;
    String Name;
    Integer Rank;

    public Record(String symbol, String name, Integer rank) {
        this.Symbol = symbol;
        this.Name = name;
        this.Rank = rank;
    }

    public String getSymbol() {
        return this.Symbol;
    }

    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getRank() {
        return this.Rank;
    }

    public void setRank(Integer Rank) {
        this.Rank = Rank;
    }

}