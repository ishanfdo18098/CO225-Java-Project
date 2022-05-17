package com.ishanadeeparidma.bidcoin.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ishanadeeparidma.bidcoin.R;

import androidx.appcompat.app.AppCompatActivity;

// This is the firs page of the app

public class Welcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Login Button Functioning
        Button LoginButton = (Button) findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling the function
                openLoginPage(view);

            }
        });





        // Create Account Button Functioning
        Button CreateAccountButton = (Button) findViewById(R.id.CreateAccountButton);
        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling the function
                openRegistrationPage(view);

            }
        });


    }

    // To navigate to the Login Page
    public void openLoginPage(View v){
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);
    }


    // To navigate to the Registration Page
    public void openRegistrationPage(View v){
        Intent myIntent = new Intent(this, RegisterNewUser.class);
        startActivity(myIntent);
    }

}