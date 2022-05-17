package com.ishanadeeparidma.bidcoin.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ishanadeeparidma.bidcoin.Models.API_TestModel;
import com.ishanadeeparidma.bidcoin.Models.LoginRequest;
import com.ishanadeeparidma.bidcoin.Models.LoginResponse;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.Repository.API_Repository;

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

    //public void openRegistrationPage(View v){
    //    Intent myIntent = new Intent(this, RegisterNewUser.class);
    //    startActivity(myIntent);
    //}
}