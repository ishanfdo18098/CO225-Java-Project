package com.IshanAdeepaRidma.BidCoinBackend.Bids;

import java.time.LocalDateTime;
import java.util.*;

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
        return bidRepository.findAll();
    }

    @PostMapping("/createBid")
    public ResponseEntity<CreateNewBidModel> addNewBid(@RequestBody CreateNewBidModel model) {
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
            return new ResponseEntity<>(model, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allInsertedBids")
    public List<SingleBidModel> getAllInsertedBids() {
        return singleBidRepository.findAll();
    }

    @GetMapping("/getInsertedBidsOnRunningBid/{cryptoName}")
    public List<SingleBidModel> getAllBidsOnARunningBid(@PathVariable("cryptoName") String cryptoName) {
        return singleBidRepository.findByCryptoName(cryptoName.toLowerCase());
    }

    @PostMapping("/insertNewBidOnRunningBid")
    public SingleBidModel insertNewBidOnRunningBid(@RequestBody SingleBidModel singleBid) {
        singleBidRepository.save(singleBid);
        return singleBid;
    }

    @GetMapping("/allWonBids")
    public List<BidWonModel> getAllBidsWon() {
        return bidWonRepository.findAll();
    }

    public static boolean checkIfTimeExpired(LocalDateTime endTime) {
        LocalDateTime now = LocalDateTime.now();
        return endTime.isBefore(now);
    }
}
