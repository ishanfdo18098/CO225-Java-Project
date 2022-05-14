package com.IshanAdeepaRidma.BidCoinBackend.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserModel> createPost(@RequestBody UserModel userModel) {
        try {
            UserModel thisUser = userRepository
                    .save(new UserModel(userModel.getEmail(), userModel.getPasswd(), false));
            return new ResponseEntity<>(thisUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/login/{email}")
    // public ResponseEntity<UserModel> getPostById(@PathVariable("email") String email) {
    //     Optional<Post> post = postRepository.findById(id);

    //     if (post.isPresent()) {
    //         return new ResponseEntity<>(post.get(), HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    // @PutMapping("/posts/{id}")
    // public ResponseEntity<Post> updatePost(@PathVariable("id") long id,
    // @RequestBody Post tutorial) {
    // Optional<Post> postData = postRepository.findById(id);
    // if (postData.isPresent()) {
    // Post _post = postData.get();
    // _post.setTitle(tutorial.getTitle());
    // _post.setDescription(tutorial.getDescription());
    // _post.setAuthor(tutorial.getAuthor());
    // _post.setPublished(tutorial.isPublished());
    // return new ResponseEntity<>(postRepository.save(_post), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // @DeleteMapping("/posts/{id}")
    // public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
    // try {
    // postRepository.deleteById(id);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @DeleteMapping("/posts")
    // public ResponseEntity<HttpStatus> deleteAllPosts() {
    // try {
    // postRepository.deleteAll();
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @GetMapping("/posts/published")
    // public ResponseEntity<List<Post>> findByPublished() {
    // try {
    // List<Post> tutorials = postRepository.findByPublished(true);
    // if (tutorials.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
    // return new ResponseEntity<>(tutorials, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}