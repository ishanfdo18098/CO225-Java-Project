package com.IshanAdeepaRidma.BidCoinBackend.Bids;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleBidRepository extends JpaRepository<SingleBidModel, Long> {
    List<SingleBidModel> findByCryptoName(String cryptoName);
}
