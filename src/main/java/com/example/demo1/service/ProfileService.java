package com.example.demo1.service;

import com.example.demo1.entity.Profile;

import java.util.List;

public interface ProfileService {
    Profile createProfile(Profile profile);

    List<Profile> fetchAllProfiles();

    Profile fetchProfileById(long profileId);

    Profile updateProfileById(Profile profile, long id);
    void deleteProfile(long id);
}
