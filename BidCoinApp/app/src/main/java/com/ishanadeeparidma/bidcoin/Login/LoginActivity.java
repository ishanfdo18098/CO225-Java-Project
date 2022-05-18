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

                } else {
                    Toast.makeText(getApplicationContext(),"Server Offline",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<API_TestModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Server Offline",Toast.LENGTH_LONG).show();
            }
        }) ;
    }

    public void loginButtonClick(View v) {

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
                    openBiddingPage();
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
    public void openBiddingPage(){
        Intent biddingPage = new Intent(LoginActivity.this, Top10CryptoActivity.class);
        //Log.d("bashith","activity is about to start");
        startActivity(biddingPage);
        //Log.d("bashith","activity is started");
    }
}