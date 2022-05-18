package com.ishanadeeparidma.bidcoin.AdminMode;

import androidx.appcompat.app.AppCompatActivity;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.CryptoRates.Top10CryptoActivity;
import com.ishanadeeparidma.bidcoin.CurrentAuctions.AllCurrentAuctions;
import com.ishanadeeparidma.bidcoin.AdminMode.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminPage1 extends AppCompatActivity {
    String emailText;
    String passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page1);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            emailText = extras.getString("email");
            passwordText = extras.getString("password");
            //The key argument here must match that used in the other activity
        }
    }

    public void viewCurrencyRates(View v){
        //FOR NOW I HAVE ADDED Top10CryptoActivity to the button:
        //Change the below line to go to another activity
        //: for Admin page2
        Intent i = new Intent(this, AdminPage2.class /*AdminPage2.class*/);
        startActivity(i);
    }

    public void viewCurrentAuctions(View v){
        //probably AllCurencyAuctions.class should be changed to AdminPage3.class
        Intent j = new Intent(this, AdminPage3.class/*AdminPage3.class*/);
        j.putExtra("email",emailText);
        j.putExtra("password",passwordText);
        startActivity(j);
    }

    public void startNewAuctions(View v){
        Intent k = new Intent(this, AdminPage4.class);
        k.putExtra("email",emailText);
        k.putExtra("password",passwordText);
        startActivity(k);
    }

}