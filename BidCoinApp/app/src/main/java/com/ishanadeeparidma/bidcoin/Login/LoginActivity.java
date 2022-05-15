package com.ishanadeeparidma.bidcoin.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ishanadeeparidma.bidcoin.Models.API_TestModel;
import com.ishanadeeparidma.bidcoin.Models.LoginRequest;
import com.ishanadeeparidma.bidcoin.Models.LoginResponse;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.Repository.API_Repository;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new API_Repository();
        BidCoinAPIAccess api = API_Repository.api;

        api.testAPI().enqueue(new Callback<API_TestModel>() {
            @Override
            public void onResponse(Call<API_TestModel> call, Response<API_TestModel> response) {
                if (response.body().getIsAlive().toString().equals("alive")) {
                    Toast.makeText(getApplicationContext(), "Server Online", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Server Offline",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<API_TestModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Server Offline",Toast.LENGTH_LONG).show();
            }
        }) ;
    }

    public void loginButtonClick(View v) throws IOException {

        EditText email = findViewById(R.id.editTextTextEmailAddress);
        EditText password = findViewById(R.id.password);

        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();

        Log.d("Button","Login Button Clicked, email:" + emailText + " password:"+ passwordText);
        BidCoinAPIAccess api = API_Repository.api;

        api.loginUser(new LoginRequest(emailText,passwordText)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                boolean isCorrect = response.body().isPasswordCorrect();
                Log.d("LOGIN API","return from API" + isCorrect);
                if (isCorrect){
                    Toast.makeText(getApplicationContext(),"Passowrd is correct!", Toast.LENGTH_SHORT).show();
//                    Password correct, send into next activity
                } else {
                    Toast.makeText(getApplicationContext(), "Passowrd is incorrect!", Toast.LENGTH_SHORT).show();
//                    Password incorrect, stay here and try again
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Server error !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openRegistrationPage(View v){
        Intent myIntent = new Intent(this, RegisterNewUser.class);
        startActivity(myIntent);
    }
}