package com.ishanadeeparidma.bidcoin.Models;

import com.google.gson.annotations.SerializedName;

public class API_TestModel {
    @SerializedName("isAlive")
    private String isAlive = "no";

    public String getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(String isAlive) {
        this.isAlive = isAlive;
    }
}
