package com.IshanAdeepaRidma.BidCoinBackend.Bids;

import java.time.LocalDateTime;
import java.util.*;

import com.IshanAdeepaRidma.BidCoinBackend.CryptoAPI.CryptoPriceController;
import com.IshanAdeepaRidma.BidCoinBackend.Users.UserModel;
import com.IshanAdeepaRidma.BidCoinBackend.Users.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bids")
public class BidController {
    @Autowired
    BidRepository bidRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SingleBidRepository singleBidRepository;

    @Autowired
    BidWonRepository bidWonRepository;

    @GetMapping("/all")
    public List<BidModel> getAllCurrentBids() {
        checkForExpiredBids();
        return bidRepository.findAll();
    }

    @PostMapping("/createBid")
    public ResponseEntity<CreateNewBidModel> addNewBid(@RequestBody CreateNewBidModel model) {
        if (model.getEndDate().plusSeconds(5).isBefore(LocalDateTime.now())) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        checkForExpiredBids();
        List<BidModel> allCurrentBids = bidRepository.findAll();
        for (BidModel bidModel : allCurrentBids) {
            if (bidModel.getCryptoName().equalsIgnoreCase(model.getCryptoName())) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        List<UserModel> usersWithEmail = userRepository.findByEmail(model.getEmail());
        UserModel thisUser = usersWithEmail.get(0);
        if (thisUser.getPasswd().equals(model.getPassword())
                && thisUser.getEmail().equals(model.getEmail()) && thisUser.isIsAdmin()) {
            bidRepository
                    .save(new BidModel(model.getStartDate(), model.getEndDate(), model.getCryptoName(),
                            model.getEmail()));
            Double priceNow = CryptoPriceController.getCurrentPriceOfCrypto(model.getCryptoName().toLowerCase());
            singleBidRepository.save(new SingleBidModel(model.getEmail() + priceNow.toString(), LocalDateTime.now(),
                    model.getCryptoName(),
                    priceNow));
            return new ResponseEntity<>(model, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allInsertedBids")
    public List<SingleBidModel> getAllInsertedBids() {
        checkForExpiredBids();
        return singleBidRepository.findAll();
    }

    @GetMapping("/getInsertedBidsOnRunningBid/{cryptoName}")
    public List<SingleBidModel> getAllBidsOnARunningBid(@PathVariable("cryptoName") String cryptoName) {
        checkForExpiredBids();
        return singleBidRepository.findByCryptoName(cryptoName.toLowerCase());
    }

    @PostMapping("/insertNewBidOnRunningBid")
    public SingleBidModel insertNewBidOnRunningBid(@RequestBody SingleBidModel singleBid) {
        checkForExpiredBids();
        if (checkIfTimeExpired(singleBid.getBidEnteredTime().plusSeconds(5)))
            return null;
        singleBidRepository.save(new SingleBidModel(singleBid.getEmail(), singleBid.getBidEnteredTime(),
                singleBid.getCryptoName(), singleBid.getBidValue()));
        return singleBid;
    }

    @GetMapping("/allWonBids")
    public List<BidWonModel> getAllBidsWon() {
        checkForExpiredBids();
        return bidWonRepository.findAll();
    }

    public static boolean checkIfTimeExpired(LocalDateTime endTime) {
        LocalDateTime now = LocalDateTime.now();
        return endTime.isBefore(now);
    }

    public void checkForExpiredBids() {
        List<BidModel> allBids = bidRepository.findAll();
        if (allBids.size() == 0)
            return;
        for (BidModel thisBid : allBids) {
            if (checkIfTimeExpired(thisBid.getEndDate())) {
                List<SingleBidModel> allSingleBids = singleBidRepository.findByCryptoName(thisBid.getCryptoName());
                SingleBidModel maximum = Collections.max(allSingleBids, new Comparator<SingleBidModel>() {
                    @Override
                    public int compare(SingleBidModel arg0, SingleBidModel arg1) {
                        return arg0.getBidValue().compareTo(arg1.getBidValue());
                    }
                });
                if (maximum == null)
                    return;
                bidWonRepository.save(new BidWonModel(maximum.getEmail(), thisBid.getCryptoName(),
                        thisBid.getStartDate(), maximum.getBidEnteredTime(), maximum.getBidValue()));

                bidRepository.delete(thisBid);
                if (allSingleBids.size() == 0)
                    return;
                for (SingleBidModel thisSingleBid : allSingleBids) {
                    singleBidRepository.delete(thisSingleBid);
                }
            }
        }
    }
}
