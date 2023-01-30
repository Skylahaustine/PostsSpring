package com.example.demo1.service;

import com.example.demo1.entity.Posts;
import org.springframework.http.ResponseEntity;

public interface PostService {


    Posts createPosts(Posts posts);
}
