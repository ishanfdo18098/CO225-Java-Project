package com.ishanadeeparidma.bidcoin.Net;


import com.ishanadeeparidma.bidcoin.Models.API_TestModel;
import com.ishanadeeparidma.bidcoin.Models.LoginModel;
import com.ishanadeeparidma.bidcoin.Models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.*;


public interface BidCoinAPIAccess {
    @GET("api/test/")
    Call<API_TestModel> testAPI();

    @POST("api/users/login")
    Call<LoginResponse> loginUser(@Body LoginModel login);
}
