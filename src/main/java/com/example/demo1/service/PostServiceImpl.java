package com.example.demo1.service;

import com.example.demo1.entity.Posts;
import com.example.demo1.repository.PostsRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Posts> fetchAllPosts() {
        return postsRepo.findAll();

    }

    @Override
    public Posts fetchPostById(long id) {
        Optional<Posts> posts = postsRepo.findById(id);
        if(posts.isPresent()){
            return  posts.get();
        }else
        {
          return   null;
        }
    }
}
