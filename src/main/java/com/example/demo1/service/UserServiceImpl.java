package com.example.demo1.service;

import com.example.demo1.entity.Posts;
import com.example.demo1.entity.Profile;
import com.example.demo1.entity.User;
import com.example.demo1.model.UserData;
import com.example.demo1.repository.PostsRepo;
import com.example.demo1.repository.UserRepo;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserData> createUser(UserData userData) {
        User user = new User();
        user.setUserName(userData.getUserName());
        user.setOtherName(userData.getOtherName());

        if (userData.getProfileData() != null) {
            Profile profile = new Profile();
            profile.setProfileName(userData.getProfileData().getProfileName());
            profile.setProfilePicture(userData.getProfileData().getProfilePicture());
            profile.setUser(user);
            user.setProfile(profile);
        }

        User savedUser = userrepo.save(user);

        UserData savedUserData = savedUser.entityToDto();
        if (savedUser.getProfile() != null) {
            savedUserData.setProfileData(savedUser.getProfile().entityToDto());
        }

        return ResponseEntity.ok(savedUserData);
    }

    @Override
    public ResponseEntity<UserData> fetchById(UserData userData) {
        return null;
    }

    @Override
    public List<User> fetchAllUsers() {
        return userrepo.findAll();



    }
}
