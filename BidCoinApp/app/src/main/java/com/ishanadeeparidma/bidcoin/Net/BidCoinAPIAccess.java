package com.ishanadeeparidma.bidcoin.Net;


import com.ishanadeeparidma.bidcoin.Models.API_TestModel;
import com.ishanadeeparidma.bidcoin.Models.LoginRequest;
import com.ishanadeeparidma.bidcoin.Models.LoginResponse;
import com.ishanadeeparidma.bidcoin.Models.RegisterRequest;
import com.ishanadeeparidma.bidcoin.Models.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.*;


public interface BidCoinAPIAccess {
    @GET("api/test/")
    Call<API_TestModel> testAPI();

    @POST("api/users/login")
    Call<LoginResponse> loginUser(@Body LoginRequest login);

    @POST("api/users/registerNewUser")
    Call<RegisterResponse> registerNewUser(@Body RegisterRequest register);
}
