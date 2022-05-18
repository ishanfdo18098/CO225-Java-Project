package com.ishanadeeparidma.bidcoin.AdminMode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.ishanadeeparidma.bidcoin.CurrentAuctions.AllCurrentAuctions;
import com.ishanadeeparidma.bidcoin.Models.Top10ResponseModel;
import com.ishanadeeparidma.bidcoin.Net.BidCoinAPIAccess;
import com.ishanadeeparidma.bidcoin.R;
import com.ishanadeeparidma.bidcoin.Repository.API_Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdminPage2 extends AppCompatActivity  {

    private LineChart Top10CryptoLineChart ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10_crypto);
        TextView textBelowChart = findViewById(R.id.editTextTextMultiLine2);

//        get api reference
        BidCoinAPIAccess api = API_Repository.api;


        // My codes.....
        ArrayList<Entry> yValue = new ArrayList<>();
        api.getTop10Crypto().enqueue(new Callback<List<Top10ResponseModel>>() {
            @Override
            public void onResponse(Call<List<Top10ResponseModel>> call, Response<List<Top10ResponseModel>> response) {

                Top10CryptoLineChart = (LineChart) findViewById(R.id.Top10CryptoLineChart);
                // Top10CryptoLineChart.setOnChartGestureListener(Top10CryptoActivity.this);
                // Top10CryptoLineChart.setOnChartValueSelectedListener(Top10CryptoActivity.this);
                Top10CryptoLineChart.setDragEnabled(true);
                //Top10CryptoLineChart.setScaleEnabled(false);

                Log.d("DEBUG123","API call successful");
                StringBuilder textUnderTheChart = new StringBuilder();
                List<Top10ResponseModel> allCryptos = response.body();
                Integer i = 1;
                for (Top10ResponseModel eachModel: allCryptos) {
                    Log.d("DEBUG123",eachModel.getName() + " " + eachModel.getPriceInUSD());
                    yValue.add(new Entry(i++, Float.parseFloat(eachModel.getPriceInUSD().toString())));
                    textUnderTheChart.append(i-1 + "\t\t" + eachModel.getName() + "\t\t" + eachModel.getSymbol().toUpperCase(Locale.ROOT) + "\t\t" + eachModel.getPriceInUSD()+"$\n");
                }
                textBelowChart.setText(textUnderTheChart);
                Log.d("DEBUG123",yValue.toString());


                LineDataSet set1 = new LineDataSet(yValue,"Data Set 1");

                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(set1);

                LineData data = new LineData(dataSets);

                Top10CryptoLineChart.setData(data);
                Top10CryptoLineChart.resetZoom();


                // Styling...
                set1.setColor(Color.GREEN);
                set1.setCircleColor(Color.BLUE);
                set1.setLabel("Currency vs Current Rate");
                set1.setDrawHorizontalHighlightIndicator(true);
                set1.setDrawIcons(true);
                set1.setDrawHorizontalHighlightIndicator(true);
                set1.setFillColor(Color.GRAY);
            }

            @Override
            public void onFailure(Call<List<Top10ResponseModel>> call, Throwable t) {
                Log.d("DEBUG123","API call NOT successful");

            }
        });

//         Adding values
//        yValue.add(new Entry(1,1000));
//        yValue.add(new Entry(2,1500));
//        yValue.add(new Entry(3,900));
//        yValue.add(new Entry(4,1800));
//        yValue.add(new Entry(5,1000));
//        yValue.add(new Entry(6,1400));
//        yValue.add(new Entry(7,1050));
//        yValue.add(new Entry(8,800));
//        yValue.add(new Entry(9,1500));
//        yValue.add(new Entry(10,1200));


        // Now, button functionality.............

        Button ViewCurrentAuctionsButton = (Button) findViewById(R.id.ViewCurrentAuctionsButton);
        ViewCurrentAuctionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling the function
                openAllCurrentAuctionsPage(view);
            }
        });
    }

    // To navigate to the Login Page
    public void openAllCurrentAuctionsPage(View v){
        Intent myIntent = new Intent(this, AllCurrentAuctions.class);
        startActivity(myIntent);
    }

}