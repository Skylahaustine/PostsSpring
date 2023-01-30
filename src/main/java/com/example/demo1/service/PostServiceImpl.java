package com.example.demo1.service;

import com.example.demo1.entity.Posts;
import com.example.demo1.repository.PostsRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl  implements  PostService{

    private final PostsRepo postsRepo;

    public PostServiceImpl(PostsRepo postsRepo) {
        this.postsRepo = postsRepo;
    }


    @Override
    public Posts createPosts(Posts posts) {
        return postsRepo.save(posts);
    }
}
