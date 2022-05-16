package com.IshanAdeepaRidma.BidCoinBackend;


import com.IshanAdeepaRidma.BidCoinBackend.CSV.ReadCSV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BidCoin_Backend {

	public static void main(String[] args) {
		ReadCSV.readCSV();
		SpringApplication.run(BidCoin_Backend.class, args);
	}

}

// Server address - 20.124.110.167:8080 - http://bidcoinco225.tk:8080/api/test