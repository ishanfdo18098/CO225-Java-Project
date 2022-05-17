package com.IshanAdeepaRidma.BidCoinBackend.CryptoAPI;

import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.CoinGeckoApiClient;
import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.impl.CoinGeckoApiClientImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crypto/")
public class Controller {
    static CoinGeckoApiClient api = new CoinGeckoApiClientImpl();

    @GetMapping("/{cryptoName}")
    public CryptoPriceModel getAllUsers(@PathVariable("cryptoName") String cryptoName) {
        return new CryptoPriceModel(cryptoName, getCurrentPriceOfCrypto(cryptoName));
    }

    public static Double getCurrentPriceOfCrypto(String cryptoName){
        return Double.valueOf(api.getPrice(cryptoName.toLowerCase(), "usd").get(cryptoName).get("usd").toString());
    }
}