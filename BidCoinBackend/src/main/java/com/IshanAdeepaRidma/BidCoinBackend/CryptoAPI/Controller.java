package com.IshanAdeepaRidma.BidCoinBackend.CryptoAPI;

import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.CoinGeckoApiClient;
import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.impl.CoinGeckoApiClientImpl;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/crypto/")
public class Controller {
    CoinGeckoApiClient api = new CoinGeckoApiClientImpl();

    @GetMapping("/{id}")
    public CryptoPriceModel getAllUsers(@PathVariable("id") String cryptoName) {
        return new CryptoPriceModel(cryptoName,
                Double.valueOf(api.getPrice(cryptoName, "usd").get(cryptoName).get("usd").toString()));
    }

    

}