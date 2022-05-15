package com.ishanadeeparidma.bidcoin.Models;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("email")
    private String email;
    @SerializedName("passwd")
    private String password;
    @SerializedName("isAdmin")
    private boolean isAdmin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
