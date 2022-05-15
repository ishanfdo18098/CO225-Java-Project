package com.ishanadeeparidma.bidcoin.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest implements Parcelable {
    @SerializedName("email")
    private String email;
    @SerializedName("passwd")
    private String password;

    public RegisterRequest(String email, String passwd){
        this.email = email;
        this.password = passwd;
    }

    protected RegisterRequest(Parcel in) {
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<RegisterRequest> CREATOR = new Creator<RegisterRequest>() {
        @Override
        public RegisterRequest createFromParcel(Parcel in) {
            return new RegisterRequest(in);
        }

        @Override
        public RegisterRequest[] newArray(int size) {
            return new RegisterRequest[size];
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
