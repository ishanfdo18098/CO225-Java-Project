package com.ishanadeeparidma.bidcoin.Bidding;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ishanadeeparidma.bidcoin.CurrentAuctions.AllCurrentAuctions;
import com.ishanadeeparidma.bidcoin.Models.WonBidsModel;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.Repository.API_Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuctionsWonByMe extends AppCompatActivity {
    LinearLayout LinearLayoutBody;
    String email = null;
    String password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page5);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            email = extras.getString("email");
            password = extras.getString("password");
            //The key argument here must match that used in the other activity
        }

        //        get api reference
        BidCoinAPIAccess api = API_Repository.api;
        LinearLayoutBody = findViewById(R.id.LinearLayoutBody);

        api.getAllWonBids().enqueue(new Callback<List<WonBidsModel>>() {
            @Override
            public void onResponse(Call<List<WonBidsModel>> call, Response<List<WonBidsModel>> response) {
                boolean foundAtLeast1 = false;
                if (response.body().size() == 0)
                    Toast.makeText(AuctionsWonByMe.this, "You haven't won any bids", Toast.LENGTH_SHORT).show();
                else {
                    for (WonBidsModel eachBid : response.body()) {

                        if (eachBid.getEmail().equals(email)) {
                            foundAtLeast1 = true;
                            TextView auctionName = new TextView(AuctionsWonByMe.this);
                            auctionName.setText("AUCTION on : " + eachBid.getCryptoName()); // Just number
                            auctionName.setTextColor(Color.parseColor("#030303")); // Changing colour
                            LinearLayoutBody.addView(auctionName);

                            TextView startAt = new TextView(AuctionsWonByMe.this);
                            startAt.setText("START : " + eachBid.getStartTime());  // Add Starting time from db
                            startAt.setTextColor(Color.parseColor("#030303")); // Changing colour
                            LinearLayoutBody.addView(startAt);

                            TextView endAt = new TextView(AuctionsWonByMe.this);
                            endAt.setText("END : " + eachBid.getEndTime());  // Add Ending time from db
                            endAt.setTextColor(Color.parseColor("#030303")); // Changing colour
                            LinearLayoutBody.addView(endAt);

                            TextView price = new TextView(AuctionsWonByMe.this);
                            price.setText("PRICE : " + eachBid.getBidWonValue());  // Add Ending time from db
                            price.setTextColor(Color.parseColor("#030303")); // Changing colour
                            LinearLayoutBody.addView(price);
                        }
                    }
                    ((TextView)findViewById(R.id.textView7)).setText("");
                    if (!foundAtLeast1){
                        ((TextView)findViewById(R.id.textView7)).setText("You havent won any auctions");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<WonBidsModel>> call, Throwable t) {
                Toast.makeText(AuctionsWonByMe.this,"Connection to server lost", Toast.LENGTH_SHORT).show();
                Log.d("CONNECTION LOST", t.toString());
            }
        });
    }
}
