package com.example.demo1.controller;

import com.example.demo1.entity.Profile;
import com.example.demo1.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {
    private  final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
@PostMapping
    public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile){

        return new ResponseEntity<Profile>(profileService.createProfile(profile), HttpStatus.CREATED) ;
    }

//    public ResponseEntity<List<Profile>> getProfiles(){
//        return  new ResponseEntity<>(profileService.getAllProfiles(), HttpStatus.OK)
//    }
}
