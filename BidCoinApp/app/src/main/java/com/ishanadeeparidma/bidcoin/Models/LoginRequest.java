package com.ishanadeeparidma.bidcoin.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class LoginRequest implements Parcelable{
    @SerializedName("email")
    private String email;
    @SerializedName("passwd")
    private String password;

    protected LoginRequest(Parcel in) {
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<LoginRequest> CREATOR = new Creator<LoginRequest>() {
        @Override
        public LoginRequest createFromParcel(Parcel in) {
            return new LoginRequest(in);
        }

        @Override
        public LoginRequest[] newArray(int size) {
            return new LoginRequest[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(password);
    }
}
