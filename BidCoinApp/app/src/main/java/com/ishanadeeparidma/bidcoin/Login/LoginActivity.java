package com.ishanadeeparidma.bidcoin.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ishanadeeparidma.bidcoin.Bidding.BiddingActivity;
import com.ishanadeeparidma.bidcoin.CryptoRates.Top10CryptoActivity;
import com.ishanadeeparidma.bidcoin.AdminMode.*;
import com.ishanadeeparidma.bidcoin.CurrentAuctions.AllCurrentAuctions;
import com.ishanadeeparidma.bidcoin.Models.API_TestModel;
import com.ishanadeeparidma.bidcoin.Models.LoginRequest;
import com.ishanadeeparidma.bidcoin.Models.LoginResponse;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.Repository.API_Repository;
import com.ishanadeeparidma.bidcoin.Bidding.BiddingActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public static boolean isServerOnline = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BidCoinAPIAccess api = API_Repository.api;

        api.testAPI().enqueue(new Callback<API_TestModel>() {
            @Override
            public void onResponse(@NonNull Call<API_TestModel> call, @NonNull Response<API_TestModel> response) {
                assert response.body() != null;
                if (response.body().getIsAlive().equals("alive")) {
                    Toast.makeText(getApplicationContext(), "Server Online", Toast.LENGTH_SHORT).show();
                    isServerOnline = true;

                } else {
                    Toast.makeText(getApplicationContext(),"Server Offline",Toast.LENGTH_LONG).show();
                    isServerOnline = false;
                }
            }

            @Override
            public void onFailure(@NonNull Call<API_TestModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Server Offline",Toast.LENGTH_LONG).show();
                isServerOnline = false;
            }
        }) ;
    }

    public void loginButtonClick(View v) {
        if (!isServerOnline){
            Toast.makeText(this,"Server is offline. Please contact admin",Toast.LENGTH_LONG).show();
            return;
        }

        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText password = findViewById(R.id.password);

        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();

        Log.d("Button","Login Button Clicked, email:" + emailText + " password:"+ passwordText);
        BidCoinAPIAccess api = API_Repository.api;

        api.loginUser(new LoginRequest(emailText,passwordText)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                assert response.body() != null;
                boolean isCorrect = response.body().isPasswordCorrect();
                Log.d("LOGIN API","return from API " + isCorrect);
                if (isCorrect){
                    Toast.makeText(getApplicationContext(),"Password is correct!", Toast.LENGTH_SHORT).show();
//                    Password correct, send into next activity
                    //=======================================
                    //for now log in page will straightly go to the bidding page
                    // Login Button Functioning
                    //Log.d("bashith","this means the initial line is executed");
                    openBiddingPage(emailText, passwordText, response.body().isAdmin());
                    //Log.d("bashith","this means the final line is executed");
                    //=======================================
                } else {
                    Toast.makeText(getApplicationContext(), "Password is incorrect!", Toast.LENGTH_SHORT).show();
//                    Password incorrect, stay here and try again
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server error !", Toast.LENGTH_SHORT).show();
            }
        });
    }




    // To navigate to the Bidding Page // >>> this should be change later to the activity that contains the graph
    public void openBiddingPage(String email, String password,boolean isAdmin){
        if (!isAdmin) {
            Intent biddingPage = new Intent(LoginActivity.this, Top10CryptoActivity.class);
            biddingPage.putExtra("email", email);
            biddingPage.putExtra("password", password);
            //Log.d("bashith","activity is about to start");
            startActivity(biddingPage);
            //Log.d("bashith","activity is started");
        } else {
            Intent adminIntent = new Intent(LoginActivity.this, AdminPage1.class);
            adminIntent.putExtra("email", email);
            adminIntent.putExtra("password", password);
            startActivity(adminIntent);
        }
    }
}