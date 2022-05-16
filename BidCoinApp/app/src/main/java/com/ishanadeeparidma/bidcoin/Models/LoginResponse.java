package com.ishanadeeparidma.bidcoin.Models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("isPasswordCorrect")
    private boolean isPasswordCorrect;
    @SerializedName("isAdmin")
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isPasswordCorrect() {
        return isPasswordCorrect;
    }

    public void setPasswordCorrect(boolean passwordCorrect) {
        isPasswordCorrect = passwordCorrect;
    }
}
