package com.IshanAdeepaRidma.BidCoinBackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class isAlive {
	@GetMapping("/test")
	public test greeting(@RequestParam(value = "value", defaultValue = "nothing") String name) {
		return new test();
	}
}

class test {
	private String isAlive = "alive";

	public String getIsAlive() {
		return isAlive;
	}

	// add self tests here to test the server at each startup of the android app
	// 1) test if db connection is working properly... etc etc
}
