package com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.domain.Status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.IshanAdeepaRidma.BidCoinBackend.CoinGecko.domain.Shared.Image;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("image")
    private Image image;

}
