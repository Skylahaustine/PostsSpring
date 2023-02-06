package com.example.demo1.controller;

import com.example.demo1.entity.Posts;
import com.example.demo1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class PostsController {
    private PostService postService;


    public PostsController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping("/posts")
    public ResponseEntity<Posts> savePosts(@RequestBody Posts posts) {
        return new ResponseEntity<Posts>(
                postService.createPosts(posts), HttpStatus.CREATED);

    }
    @GetMapping("/posts")
    public List<Posts> getAllPosts(){
        return postService.fetchAllPosts();
    }

    @GetMapping("/posts/{id}")
    public  ResponseEntity<Posts> getPostById( @PathVariable("id") long postId){
        return new ResponseEntity<>(postService.fetchPostById(postId), HttpStatus.OK);

}
}
