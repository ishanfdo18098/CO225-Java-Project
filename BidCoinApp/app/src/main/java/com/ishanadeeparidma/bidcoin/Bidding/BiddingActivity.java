package com.ishanadeeparidma.bidcoin.Bidding;

import androidx.appcompat.app.AppCompatActivity;

import com.ishanadeeparidma.bidcoin.Login.RegisterNewUser;
import com.ishanadeeparidma.bidcoin.Models.SingleBidResponse;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.Repository.API_Repository;

import android.content.Intent;
import android.os.Handler;
import android.view.View;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiddingActivity extends AppCompatActivity {

    String email = null;
    String password = null;
    String cryptoName = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);

        BidCoinAPIAccess api = API_Repository.api;


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            email = extras.getString("email");
            password = extras.getString("password");
            cryptoName = extras.getString("cryptoName");
            //The key argument here must match that used in the other activity
        }

        EditText cryptoNameText = findViewById(R.id.editTextTextPersonName2);
        cryptoNameText.setText(cryptoName);
        cryptoNameText.setFocusable(false);

        EditText bidderName = findViewById(R.id.editTextTextPersonName3);
        bidderName.setText(email);
        bidderName.setFocusable(false);

        TextView currentPrice = findViewById(R.id.currentPrice);
        api.getAllBidsOnASingleRunningBid(cryptoName).enqueue(new Callback<List<SingleBidResponse>>() {
            @Override
            public void onResponse(Call<List<SingleBidResponse>> call, Response<List<SingleBidResponse>> response) {
                Double maximum = 0.00;
                for (SingleBidResponse each: response.body()){
                    if (maximum < each.getBidValue())
                        maximum = each.getBidValue();
                }

                currentPrice.setText("Current Bid: $"+maximum.toString());
            }

            @Override
            public void onFailure(Call<List<SingleBidResponse>> call, Throwable t) {

            }
        });
    }

    public void onSubmitButtonClick(View v){
        EditText bidPriceEditText = findViewById(R.id.editTextTextPersonName4);
        Double bidValue = Double.valueOf(bidPriceEditText.getText().toString());

        BidCoinAPIAccess api = API_Repository.api;

        api.insertNewBidOnRunningBid(new SingleBidResponse(email, LocalDateTime.now().toString(),cryptoName, bidValue)).enqueue(new Callback<SingleBidResponse>() {
            @Override
            public void onResponse(Call<SingleBidResponse> call, Response<SingleBidResponse> response) {
                Toast.makeText(BiddingActivity.this, "Bid inserted, You will be redirected in 2seconds", Toast.LENGTH_SHORT).show();
//                after a 2 second delay, go to previous activity
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        finish();
                    }
                }, 2000);

            }

            @Override
            public void onFailure(Call<SingleBidResponse> call, Throwable t) {
                Toast.makeText(BiddingActivity.this, "Server error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void selectCrypto(View v){
        Intent i =  new Intent(this, SelectCurrencyActivity.class);
        startActivity(i);
    }
}