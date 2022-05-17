package com.IshanAdeepaRidma.BidCoinBackend.Top10;

import java.util.*;

import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.CoinGeckoApiClient;
import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.domain.Coins.CoinMarkets;
import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.impl.CoinGeckoApiClientImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/top10/")
public class Top10Endpoint {
    static CoinGeckoApiClient api = new CoinGeckoApiClientImpl();

    @GetMapping("/")
    public List<Top10Model> getTop10Cryptos() {
        List<Top10Model> returnThis = new ArrayList<Top10Model>();
        List<CoinMarkets> allDataFromAPI = api.getCoinMarkets("usd");
        for (CoinMarkets eachCoin : allDataFromAPI) {
            returnThis.add(new Top10Model(eachCoin.name, eachCoin.symbol, eachCoin.currentPrice));
        }

        returnThis.sort(new Comparator<Top10Model>() {
            @Override
            public int compare(Top10Model arg0, Top10Model arg1) {
                if (arg0.getPriceInUSD().equals(arg1.getPriceInUSD())) {
                    return 0;
                } else if (arg0.getPriceInUSD() > arg1.getPriceInUSD()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        returnThis = returnThis.subList(0, 10);

        return returnThis;
    }
}
