package com.ishanadeeparidma.bidcoin.Bidding;

import androidx.appcompat.app.AppCompatActivity;
import com.ishanadeeparidma.bidcoin.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class SelectCurrencyActivity extends AppCompatActivity {

    String[] items =  {"Bitcoin","Ethereum","Tether(USDT)","USD Coin(USDC)","BNB","XRP","Cardano","Solana","Binance USD","Polkadot","Dogecoin","Avalanche","Wrapped Bitcoin","Lido Staked Ether","TRON","Shiba Inu","Dai","Litecoin","Cronos","Polygon","LEO Token","NEAR Protocol","FTX Token","Bitcoin Cash","Chainlink","Stellar","Algorand","Cosmos Hub","OKB","Flow"};


    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_currency);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });
    }
}