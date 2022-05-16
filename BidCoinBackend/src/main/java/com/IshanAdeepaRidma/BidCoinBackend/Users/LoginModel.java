package com.IshanAdeepaRidma.BidCoinBackend.Users;

public class LoginModel {
    private boolean isPasswordCorrect;
    private boolean isAdmin;

    public LoginModel(boolean isCorrect, boolean isAdmin) {
        this.isPasswordCorrect = isCorrect;
        this.isAdmin = isAdmin;
    }

    public boolean isIsPasswordCorrect() {
        return this.isPasswordCorrect;
    }

    public void setIsPasswordCorrect(boolean isPasswordCorrect) {
        this.isPasswordCorrect = isPasswordCorrect;
    }

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
