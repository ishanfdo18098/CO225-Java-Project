package com.ishanadeeparidma.bidcoin.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDateTime;

public class SingleBidResponse implements Parcelable {
    private String email;
    private String bidEnteredTime;
    private String cryptoName;
    private Double bidValue;

    public SingleBidResponse(String email, String bidEnteredTime, String cryptoName, Double bidValue) {
        this.email = email;
        this.bidEnteredTime = bidEnteredTime;
        this.cryptoName = cryptoName;
        this.bidValue = bidValue;
    }

    protected SingleBidResponse(Parcel in) {
        email = in.readString();
        cryptoName = in.readString();
        if (in.readByte() == 0) {
            bidValue = null;
        } else {
            bidValue = in.readDouble();
        }
    }

    public static final Creator<SingleBidResponse> CREATOR = new Creator<SingleBidResponse>() {
        @Override
        public SingleBidResponse createFromParcel(Parcel in) {
            return new SingleBidResponse(in);
        }

        @Override
        public SingleBidResponse[] newArray(int size) {
            return new SingleBidResponse[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBidEnteredTime() {
        return bidEnteredTime;
    }

    public void setBidEnteredTime(String bidEnteredTime) {
        this.bidEnteredTime = bidEnteredTime;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public Double getBidValue() {
        return bidValue;
    }

    public void setBidValue(Double bidValue) {
        this.bidValue = bidValue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(cryptoName);
        if (bidValue == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(bidValue);
        }
    }
}
