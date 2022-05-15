package com.ishanadeeparidma.bidcoin.Repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ishanadeeparidma.bidcoin.Models.API_TestModel;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_Repository {
    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://bidcoinco225.tk:8080").addConverterFactory(GsonConverterFactory.create(gson)).build();

    public static BidCoinAPIAccess api = null;

    public API_Repository(){
        if (api == null) {
            api = retrofit.create(BidCoinAPIAccess.class);
        }
    }

}
