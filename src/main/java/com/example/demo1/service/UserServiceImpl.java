package com.example.demo1.service;

import com.example.demo1.entity.Posts;
import com.example.demo1.entity.User;
import com.example.demo1.repository.PostsRepo;
import com.example.demo1.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userrepo;
    private final PostsRepo postsrepo;

    public UserServiceImpl(UserRepo userrepo, PostsRepo postsrepo) {
        this.userrepo = userrepo;
        this.postsrepo = postsrepo;
    }

    @Override
    public User createUser(User user) {
        return userrepo.save(user);

    }

    @Override
    public User createUserWithPosts(User user) {
        User savedUser=userrepo.save(user);
        List<Posts> posts =user.getPosts();
        for (Posts post: posts){
            post.setUser(savedUser);
            postsrepo.save(post);

        }
        return savedUser;
    }

    @Override
    public List<User> fetchAllUsers() {
        return userrepo.findAll();


    }
}
