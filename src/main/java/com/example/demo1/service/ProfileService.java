package com.example.demo1.service;

import com.example.demo1.entity.Profile;
import com.example.demo1.model.ProfileData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfileService {
    ResponseEntity<ProfileData> createProfile(ProfileData profileData);

    ResponseEntity<List<ProfileData>> fetchAllProfiles();

//    Profile fetchProfileById(long profileId);

    ResponseEntity<ProfileData> updateProfileById(ProfileData profileData, long id);
    void deleteProfile(long id);

    ProfileData getProfileById(Long id);
}
