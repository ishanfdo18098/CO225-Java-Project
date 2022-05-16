package com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.domain.Exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.domain.Shared.Ticker;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangesTickersById {
    @JsonProperty("name")
    private String name;
    @JsonProperty("tickers")
    private List<Ticker> tickers;

}
