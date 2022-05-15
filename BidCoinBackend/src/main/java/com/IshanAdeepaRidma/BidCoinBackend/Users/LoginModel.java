package com.IshanAdeepaRidma.BidCoinBackend.Users;

public class LoginModel {
    private boolean isPasswordCorrect;

    public LoginModel(boolean isCorrect) {
        this.isPasswordCorrect = isCorrect;
    }

    public boolean isIsPasswordCorrect() {
        return this.isPasswordCorrect;
    }

    public void setIsPasswordCorrect(boolean isPasswordCorrect) {
        this.isPasswordCorrect = isPasswordCorrect;
    }

}
