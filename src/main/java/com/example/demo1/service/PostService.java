package com.example.demo1.service;

import com.example.demo1.entity.Posts;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {


    Posts createPosts(Posts posts);

    List<Posts> fetchAllPosts();
    Posts fetchPostById(long id);
}
