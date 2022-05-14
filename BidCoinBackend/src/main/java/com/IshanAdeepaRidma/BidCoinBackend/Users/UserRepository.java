package com.IshanAdeepaRidma.BidCoinBackend.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long> {

    List<UserModel> findByEmail(String email);

}
