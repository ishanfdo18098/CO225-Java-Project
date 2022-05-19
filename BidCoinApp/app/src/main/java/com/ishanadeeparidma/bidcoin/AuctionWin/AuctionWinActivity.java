package com.ishanadeeparidma.bidcoin.AuctionWin;

import androidx.appcompat.app.AppCompatActivity;
import com.ishanadeeparidma.bidcoin.R;
import android.os.Bundle;
import android.widget.TextView;

public class AuctionWinActivity extends AppCompatActivity {
    TextView highestBidder;
    TextView cryptoCurrency;
    TextView bidValue;
    String wonBy;
    String crypto;
    String bidPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction_win);
    }
}