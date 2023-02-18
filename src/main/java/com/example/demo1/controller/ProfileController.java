package com.example.demo1.controller;

import com.example.demo1.entity.Profile;
import com.example.demo1.model.ProfileData;
import com.example.demo1.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileData> saveProfile(@RequestBody ProfileData profileData) {

        return profileService.createProfile(profileData);
    }
    @GetMapping
    public ResponseEntity<List<ProfileData>>getAllProfiles() {
        return profileService.fetchAllProfiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileData> getProfileById(@PathVariable Long id) {
        ProfileData profileData = profileService.getProfileById(id);
        if (profileData != null) {
            return new ResponseEntity<>(profileData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileData> updateProfile(@PathVariable("id") long id,
                                                 @RequestBody ProfileData profileData) {
        return profileService.updateProfileById(profileData, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfileById(@PathVariable("id") long id){
        profileService.deleteProfile(id);
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }
}
