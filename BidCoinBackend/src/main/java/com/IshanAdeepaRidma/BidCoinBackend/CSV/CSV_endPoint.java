package com.IshanAdeepaRidma.BidCoinBackend.CSV;

import java.util.*;
import java.util.function.Consumer;

import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.CoinGeckoApiClient;
import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.impl.CoinGeckoApiClientImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/csv/")
public class CSV_endPoint {
    CoinGeckoApiClient api = new CoinGeckoApiClientImpl();

    @GetMapping("/all")
    public List<CSV_ResponseModel> getAllRecords() {
        List<CSV_ResponseModel> returnThis = new ArrayList<>();
        ReadCSV.allCurrencies.forEach(new Consumer<Record>() {
            @Override
            public void accept(Record arg0) {
                returnThis.add(new CSV_ResponseModel(arg0.getSymbol(), arg0.getName(), arg0.getRank()));
            }
        });
        return returnThis;
    }

    @GetMapping("/{index}")
    public CSV_ResponseModel getSingleRecord(@PathVariable("index") String index) {
        Record thisRecord = ReadCSV.allCurrencies.get(Integer.valueOf(index)-1);
        return new CSV_ResponseModel(thisRecord.getSymbol(), thisRecord.getName(), thisRecord.getRank());
    }

}
