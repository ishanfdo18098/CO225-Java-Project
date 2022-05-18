package com.IshanAdeepaRidma.BidCoinBackend.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // just for testing. should turn this off later
    @GetMapping("/getAllUsers")
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/registerNewUser")
    public ResponseEntity<UserModel> registerNewUser(@RequestBody UserModel userModel) {
        try {
            List<UserModel> allUsersWithEmail = userRepository.findByEmail(userModel.getEmail());
            if (allUsersWithEmail.size() != 0) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            UserModel thisUser = userRepository
                    .save(new UserModel(userModel.getEmail(), userModel.getPasswd(), false));
            return new ResponseEntity<>(thisUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public LoginModel login(@RequestBody UserModel userModel) {
        List<UserModel> thisUser = userRepository.findByEmail(userModel.getEmail());
        for (UserModel eachUserModel : thisUser) {
            if (eachUserModel.getPasswd().equals(userModel.getPasswd())) {
                return new LoginModel(true, eachUserModel.isIsAdmin());
            }
        }
        return new LoginModel(false, false);
    }

    @GetMapping("/date")
    public String getDateAndTimeNow() {
        return LocalDateTime.now().toString();
    }

}