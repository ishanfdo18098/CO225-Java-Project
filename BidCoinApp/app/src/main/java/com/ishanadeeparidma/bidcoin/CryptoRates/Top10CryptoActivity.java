package com.ishanadeeparidma.bidcoin.CryptoRates;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.ishanadeeparidma.bidcoin.R;

import android.graphics.Color;
import android.os.Bundle;
import java.util.ArrayList;



public class Top10CryptoActivity extends AppCompatActivity  {

    private LineChart Top10CryptoLineChart ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10_crypto);

        // My codes......
        Top10CryptoLineChart = (LineChart) findViewById(R.id.Top10CryptoLineChart);
        // Top10CryptoLineChart.setOnChartGestureListener(Top10CryptoActivity.this);
        // Top10CryptoLineChart.setOnChartValueSelectedListener(Top10CryptoActivity.this);
        Top10CryptoLineChart.setDragEnabled(true);
        //Top10CryptoLineChart.setScaleEnabled(false);

        ArrayList<Entry> yValue = new ArrayList<>();
        // Adding values
        yValue.add(new Entry(1,1000));
        yValue.add(new Entry(2,1500));
        yValue.add(new Entry(3,900));
        yValue.add(new Entry(4,1800));
        yValue.add(new Entry(5,1000));
        yValue.add(new Entry(6,1400));
        yValue.add(new Entry(7,1050));
        yValue.add(new Entry(8,800));
        yValue.add(new Entry(9,1500));
        yValue.add(new Entry(10,1200));


        LineDataSet set1 = new LineDataSet(yValue,"Data Set 1");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        Top10CryptoLineChart.setData(data);


        // Styling...
        set1.setColor(Color.GREEN);
        set1.setCircleColor(Color.BLUE);
        set1.setLabel("Currency vs Current Rate");
        set1.setDrawHorizontalHighlightIndicator(true);
        set1.setDrawIcons(true);
        set1.setDrawHorizontalHighlightIndicator(true);
        set1.setFillColor(Color.GRAY);


    }
}