package com.ishanadeeparidma.bidcoin.Models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("isPasswordCorrect")
    private boolean isPasswordCorrect;

    public boolean isPasswordCorrect() {
        return isPasswordCorrect;
    }

    public void setPasswordCorrect(boolean passwordCorrect) {
        isPasswordCorrect = passwordCorrect;
    }
}
