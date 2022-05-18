package com.ishanadeeparidma.bidcoin.Net;


import com.ishanadeeparidma.bidcoin.Models.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;


public interface BidCoinAPIAccess {
    @GET("api/test/")
    Call<API_TestModel> testAPI();

    @POST("api/users/login")
    Call<LoginResponse> loginUser(@Body LoginRequest login);

    @POST("api/users/registerNewUser")
    Call<RegisterResponse> registerNewUser(@Body RegisterRequest register);

    @GET("api/crypto/{cryptoName}")
    Call<CryptoPriceResponse> getSingleCryptoPrice(@Path("cryptoName") String cryptoName);

    @GET("api/csv/all")
    Call<List<CSV_File_Response>> getAllCSVContents();

    @GET("api/csv/{rank}")
    Call<CSV_File_Response> getCSVByRank(@Path("rank") String rank);

    @GET("api/top10/")
    Call<List<Top10ResponseModel>> getTop10Crypto();

    @GET("api/bids/all")
    Call<List<RunningBidResponse>> getCurrentRunningBids();

    @POST("api/bids/createBid")
    Call<StartNewBidByAdminModel> startNewBidByAdmin(@Body StartNewBidByAdminModel reqBody);

    @GET("api/bids/allInsertedBids")
    Call<List<SingleBidResponse>> viewAllInsertedBidsOnRunningBid();

    @GET("api/bids/getInsertedBidsOnRunningBid/{cryptoName}")
    Call<List<SingleBidResponse>> getAllBidsOnASingleRunningBid(@Path("cryptoName") String cryptoName);

    @POST("api/bids/insertNewBidOnRunningBid")
    Call<SingleBidResponse> insertNewBidOnRunningBid(@Body SingleBidResponse singleBid);

    @GET("api/bids/allWonBids")
    Call<List<WonBidsModel>> getAllWonBids();

    @GET("api/admin/cancelBid/{cryptoName}")
    Call<AdminCancelBidModel> cancelBidByAdmin(@Path("cryptoName") String cryptoName);

}
