package com.ishanadeeparidma.bidcoin.CurrentAuctions;

import androidx.appcompat.app.AppCompatActivity;
import com.ishanadeeparidma.bidcoin.R;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AllCurrentAuctions extends AppCompatActivity {

    LinearLayout  LinearLayoutBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_current_auctions);

        LinearLayoutBody = findViewById(R.id.LinearLayoutBody);
        //Adding 2 TextViews
        for (int i = 1; i <= 5; i++) {
            TextView auctionName = new TextView(this);
            auctionName.setText("AUCTION " + String.valueOf(i)); // Just number
            LinearLayoutBody.addView(auctionName);

            TextView startAt = new TextView(this);
            startAt.setText("START " + String.valueOf(i));  // Add Starting time from db
            LinearLayoutBody.addView(startAt);

            TextView endAt = new TextView(this);
            endAt.setText("END " + String.valueOf(i));  // Add Ending time from db
            LinearLayoutBody.addView(endAt);

            // Button also
            Button SelectButton = new Button(this);
            SelectButton.setText("SELECT");
            LinearLayoutBody.addView(SelectButton);

        }
    }
}