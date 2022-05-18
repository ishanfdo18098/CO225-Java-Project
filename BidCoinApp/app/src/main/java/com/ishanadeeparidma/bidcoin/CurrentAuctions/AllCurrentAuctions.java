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
            TextView textView = new TextView(this);
            textView.setText("TextView " + String.valueOf(i));
            LinearLayoutBody.addView(textView);

            // Button also
            Button SelectButton = new Button(this);
            SelectButton.setText("SELECT");
            LinearLayoutBody.addView(SelectButton);

        }
    }
}