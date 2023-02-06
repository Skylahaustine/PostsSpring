package com.example.demo1.service;

import com.example.demo1.entity.Profile;
import com.example.demo1.repository.ProfileRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProfileServiceImpl implements ProfileService{
    private  final ProfileRepo profileRepo;

    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    @Override
    public List<Profile> fetchAllProfiles() {
        return profileRepo.findAll();
    }
}
