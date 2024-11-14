package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.ProfileRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.dto.response.ProfileResponse;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.service.PlayerService;
import com.example.CricBuzz.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {


    @Autowired
    ProfileService profileService;

    @PostMapping
    public ProfileResponse addPlayerProfile(@RequestBody ProfileRequest profileRequest,
                                            @RequestParam("player-id") int playerId) {
          return profileService.addPlayerProfile(profileRequest,playerId);
    }
}
