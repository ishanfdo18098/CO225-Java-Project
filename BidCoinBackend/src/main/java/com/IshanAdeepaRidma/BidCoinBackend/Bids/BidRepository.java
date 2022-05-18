package com.IshanAdeepaRidma.BidCoinBackend.Bids;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<BidModel, Long> {
    BidModel findByCryptoName(String cryptoName);
}


