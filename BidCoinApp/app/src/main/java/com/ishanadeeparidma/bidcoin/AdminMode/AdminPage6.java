package com.ishanadeeparidma.bidcoin.AdminMode;

import androidx.appcompat.app.AppCompatActivity;
import com.ishanadeeparidma.bidcoin.R;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class AdminPage6 extends AppCompatActivity {
    TextView highestBidder;
    TextView cryptoCurrency;
    TextView bidValue;
    String wonBy;
    String crypto;
    String bidPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page6);

        highestBidder = findViewById(R.id.textView3);
        cryptoCurrency = findViewById(R.id.textView4);
        bidValue = findViewById(R.id.textView5);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            wonBy = extras.getString("wonBy");
            crypto = extras.getString("crypto");
            bidPrice = extras.getString("bidPrice");
            //The key argument here must match that used in the other activity
        }

        highestBidder.setText("HIGHEST BIDDER: "+wonBy);
        cryptoCurrency.setText("CRYPTOCURRENCY: " + crypto.toUpperCase(Locale.ROOT));
        bidValue.setText("BID PRICE: $"+bidPrice);
    }
}