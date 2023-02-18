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
    public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) {

        return new ResponseEntity<Profile>(profileService.createProfile(profile), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Profile> getAllProfiles() {
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
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") long id,
                                                 @RequestBody Profile profile) {
        return new ResponseEntity<Profile>(
                profileService.updateProfileById(profile, id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfileById(@PathVariable("id") long id){
        profileService.deleteProfile(id);
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }
}
