package com.ishanadeeparidma.bidcoin.Admin;

import androidx.appcompat.app.AppCompatActivity;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.CryptoRates.Top10CryptoActivity;
import com.ishanadeeparidma.bidcoin.CurrentAuctions.AllCurrentAuctions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_start);
    }

    public void viewCurrencyRates(View v){
        Intent i = new Intent(this, Top10CryptoActivity.class)
        startActivity(i);
    }

    public void viewCurrentAuctions(View v){
        Intent i = new Intent(this, AllCurrentAuctions.class)
        startActivity(i);
    }

    public void startNewAuctions(View v){
        Intent i = new Intent(this, AllCurrentAuctions.class)
        startActivity(i);
    }

}