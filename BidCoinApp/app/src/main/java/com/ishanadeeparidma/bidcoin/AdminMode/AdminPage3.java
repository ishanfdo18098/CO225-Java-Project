package com.ishanadeeparidma.bidcoin.AdminMode;

import androidx.appcompat.app.AppCompatActivity;

import com.ishanadeeparidma.bidcoin.Bidding.BiddingActivity;
import com.ishanadeeparidma.bidcoin.Models.CryptoPriceResponse;
import com.ishanadeeparidma.bidcoin.Models.RunningBidResponse;
import com.ishanadeeparidma.bidcoin.Models.SingleBidResponse;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.Repository.API_Repository;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminPage3 extends AppCompatActivity {

    LinearLayout  LinearLayoutBody;
    String email = null;
    String password = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_current_auctions);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            email = extras.getString("email");
            password = extras.getString("password");
            //The key argument here must match that used in the other activity
        }

        //        get api reference
        BidCoinAPIAccess api = API_Repository.api;
        LinearLayoutBody = findViewById(R.id.LinearLayoutBody);

        api.getCurrentRunningBids().enqueue(new Callback<List<RunningBidResponse>>() {
            @Override
            public void onResponse(Call<List<RunningBidResponse>> call, Response<List<RunningBidResponse>> response) {
                assert response.body() != null;
                if (response.body().size() == 0)
                    Toast.makeText(AdminPage3.this, "No currently running bids", Toast.LENGTH_SHORT).show();
                else {
                    for (RunningBidResponse eachBid : response.body()) {
                        TextView auctionName = new TextView(AdminPage3.this);
                        auctionName.setText("AUCTION on : " + eachBid.getCryptoName()); // Just number
                        LinearLayoutBody.addView(auctionName);

                        TextView startAt = new TextView(AdminPage3.this);
                        startAt.setText("START : " + eachBid.getStartDate());  // Add Starting time from db
                        LinearLayoutBody.addView(startAt);

                        TextView endAt = new TextView(AdminPage3.this);
                        endAt.setText("END : "  + eachBid.getEndDate());  // Add Ending time from db
                        LinearLayoutBody.addView(endAt);

                        // Button also
                        Button SelectButton = new Button(AdminPage3.this);
                        SelectButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i = new Intent(AdminPage3.this, BiddingActivity.class);
                                i.putExtra("cryptoName",eachBid.getCryptoName());
                                i.putExtra("email",email);
                                i.putExtra("password",password);
                                startActivity(i);
                            }
                        });
                        SelectButton.setText("SELECT");
                        LinearLayoutBody.addView(SelectButton);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<RunningBidResponse>> call, Throwable t) {
                Toast.makeText(AdminPage3.this,"Connection to server lost", Toast.LENGTH_SHORT).show();
                Log.d("CONNECTION LOST", t.toString());
            }
        });

//
//        //Adding 2 TextViews
//        for (int i = 1; i <= 5; i++) {
//            TextView auctionName = new TextView(this);
//            auctionName.setText("AUCTION " + String.valueOf(i)); // Just number
//            LinearLayoutBody.addView(auctionName);
//
//            TextView startAt = new TextView(this);
//            startAt.setText("START " + String.valueOf(i));  // Add Starting time from db
//            LinearLayoutBody.addView(startAt);
//
//            TextView endAt = new TextView(this);
//            endAt.setText("END " + String.valueOf(i));  // Add Ending time from db
//            LinearLayoutBody.addView(endAt);
//
//            // Button also
//            Button SelectButton = new Button(this);
//            SelectButton.setText("SELECT");
//            LinearLayoutBody.addView(SelectButton);
//
//        }
    }
}