package com.ishanadeeparidma.bidcoin.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ishanadeeparidma.bidcoin.Models.RegisterRequest;
import com.ishanadeeparidma.bidcoin.Models.RegisterResponse;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.Repository.API_Repository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterNewUser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_user);
    }

    public void registerButtonClick(View v){
        String email = ((EditText)findViewById(R.id.registerEmail)).getText().toString();
        String password = ((EditText)findViewById(R.id.registerPassword)).getText().toString();

        BidCoinAPIAccess api = API_Repository.api;
        api.registerNewUser(new RegisterRequest(email, password)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (email.equals(response.body().getEmail()) && password.equals(response.body().getPassword())){
                    Toast.makeText(RegisterNewUser.this, "Registration Successful",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterNewUser.this, "Server Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}