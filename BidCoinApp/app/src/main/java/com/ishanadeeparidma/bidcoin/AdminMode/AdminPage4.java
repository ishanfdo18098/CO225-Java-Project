package com.ishanadeeparidma.bidcoin.AdminMode;

import androidx.appcompat.app.AppCompatActivity;

import com.ishanadeeparidma.bidcoin.Models.StartNewBidByAdminModel;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;

import com.ishanadeeparidma.bidcoin.Repository.API_Repository;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminPage4 extends AppCompatActivity {


    EditText date_time_end;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            email = extras.getString("email");
            password = extras.getString("password");
            //The key argument here must match that used in the other activity
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        date_time_end=findViewById(R.id.date_time_input2);

        date_time_end.setInputType(InputType.TYPE_NULL);

        date_time_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  showDateTimeDialog(date_time_end);
            }
        });



    }

    private void showDateTimeDialog(final EditText date_time) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);

                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd HH:mm");

                        date_time.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };

                new TimePickerDialog(AdminPage4.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };

        new DatePickerDialog(AdminPage4.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

    // The app craches when the EditText is converted to strings;
    // probably because at this time there is no string to be converted
    //if we trigger this after a date is selected then it might work
    //didnt check

    //String startTime = date_time_start.getText().toString();
    //String endTime = date_time_end.getText().toString();

    public void confirmButton(View V){
        //        get api reference
        BidCoinAPIAccess api = API_Repository.api;

        String endTime = date_time_end.getText().toString();
        if (endTime.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please select Date and Time", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] splittedTime = endTime.split(" ");
        endTime = String.format("20%sT%s:05.9483536",splittedTime[0],splittedTime[1]);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        Log.d("TEXTTTT",endDateTime.toString().substring(0,27));
        Log.d("TEXTTTT",LocalDateTime.now().toString()+"0000");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        api.startNewBidByAdmin(new StartNewBidByAdminModel(email,password, LocalDateTime.now().toString()+"0000", endDateTime.toString().substring(0,27),spinner.getSelectedItem().toString().toLowerCase(Locale.ROOT))).enqueue(new Callback<StartNewBidByAdminModel>() {
            @Override
            public void onResponse(Call<StartNewBidByAdminModel> call, Response<StartNewBidByAdminModel> response) {
                StartNewBidByAdminModel responseBody = response.body();
                if (responseBody.getCryptoName().equals(spinner.getSelectedItem().toString().toLowerCase(Locale.ROOT))){
                    Toast.makeText(getApplicationContext(), "New Bid Started! You will be redirected in 2 seconds", Toast.LENGTH_SHORT).show();
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        Intent nextIntent = new Intent(AdminPage4.this, AdminPage5.class);
                        nextIntent.putExtra("email",email);
                        nextIntent.putExtra("password",password);
                        startActivity(nextIntent);
                    }
                }, 2000);
            }

            @Override
            public void onFailure(Call<StartNewBidByAdminModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed! Please try again later", Toast.LENGTH_SHORT).show();

            }
        });
    }



}
