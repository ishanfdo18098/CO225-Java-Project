package com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.domain.Exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.domain.Shared.Ticker;
import lombok.*;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
public class ExchangeById extends Exchanges {
    @JsonProperty("tickers")
    private List<Ticker> tickers;
    @JsonProperty("status_updates")
    private List<Object> statusUpdates;

}
