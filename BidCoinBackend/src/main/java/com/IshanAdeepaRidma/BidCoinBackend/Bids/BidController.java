package com.IshanAdeepaRidma.BidCoinBackend.Bids;

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

    @GetMapping("/all")
    public List<BidModel> getAllCurrentBids() {
        return bidRepository.findAll();
    }

    @PostMapping("/addBid")
    public ResponseEntity<CreateNewBidModel> addNewBid(@RequestBody CreateNewBidModel model) {
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
}
