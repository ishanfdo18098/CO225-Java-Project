package com.IshanAdeepaRidma.BidCoinBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IshanAdeepaRidma.BidCoinBackend.model.Post;


public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByPublished(boolean published);

}


