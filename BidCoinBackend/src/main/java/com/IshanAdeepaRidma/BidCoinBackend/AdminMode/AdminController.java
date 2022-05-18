package com.IshanAdeepaRidma.BidCoinBackend.AdminMode;

import java.time.LocalDateTime;
import java.util.*;

import com.IshanAdeepaRidma.BidCoinBackend.Bids.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    @Autowired
    BidRepository bidRepository;
    @Autowired
    SingleBidRepository singleBidRepository;
    @Autowired
    BidWonRepository bidWonRepository;

    @GetMapping("/cancelBid/{cryptoName}")
    public BidCancelModel cancelSingleBid(@PathVariable("cryptoName") String cryptoName) {
        BidModel thisBid = bidRepository.findByCryptoName(cryptoName);
        if (thisBid == null) {
            return new BidCancelModel("Error", "Error", 0.00);
        }

        List<SingleBidModel> allSingleBids = singleBidRepository.findByCryptoName(cryptoName);

        if (allSingleBids.size() == 0) {
            bidRepository.delete(thisBid);
            return new BidCancelModel(thisBid.getCryptoName(), "None", 0.0);
        }

        SingleBidModel maximumBid = null;
        Double maximumBidValue = 0.00;

        for (SingleBidModel each : allSingleBids) {
            if (maximumBidValue < each.getBidValue()) {
                maximumBidValue = each.getBidValue();
                maximumBid = each;
            }
        }

        bidWonRepository.save(new BidWonModel(maximumBid.getEmail(), maximumBid.getCryptoName(), thisBid.getStartDate(),
                LocalDateTime.now(), maximumBid.getBidValue()));
        String wonName = maximumBid.getEmail();
        Double bidWonPrice = maximumBid.getBidValue();

        for (SingleBidModel each : allSingleBids) {
            singleBidRepository.delete(each);
        }
        return new BidCancelModel(cryptoName, wonName, bidWonPrice);
    }
}
