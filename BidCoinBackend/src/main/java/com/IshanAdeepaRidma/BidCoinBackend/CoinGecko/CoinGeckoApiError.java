package com.IshanAdeepaRidma.BidCoinBackend.CoinGecko;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class CoinGeckoApiError {
    @JsonProperty("code")
    private int code;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @JsonProperty("error")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
