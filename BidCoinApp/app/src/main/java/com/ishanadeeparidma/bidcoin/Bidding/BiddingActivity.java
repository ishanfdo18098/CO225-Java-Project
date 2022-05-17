package com.ishanadeeparidma.bidcoin.Bidding;

import androidx.appcompat.app.AppCompatActivity;

import com.ishanadeeparidma.bidcoin.Login.RegisterNewUser;
import com.ishanadeeparidma.bidcoin.R;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.util.Log;

public class BiddingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidding);
    }

    public void selectCrypto(View v){
        Intent i =  new Intent(this, SelectCurrencyActivity.class);
        startActivity(i);
    }
}