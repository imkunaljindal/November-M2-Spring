package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.ProfileConvertor;
import com.example.CricBuzz.dto.request.ProfileRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.dto.response.ProfileResponse;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.PlayerProfile;
import com.example.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    PlayerRepository playerRepository;

    public ProfileResponse addPlayerProfile(ProfileRequest profileRequest,
                                            int playerId) {
//        Player player = playerRepository.findById(playerId)
//                .orElseThrow(() -> new PlayerNotFoundException("Invalid Player id"));

        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if (optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player Id");
        }
        Player player = optionalPlayer.get();

        PlayerProfile playerProfile = ProfileConvertor.profileRequstToProfile(profileRequest);
        player.setProfile(playerProfile);
        playerProfile.setPlayer(player);

        Player savedPlayer = playerRepository.save(player); // player + playerprofile

        return ProfileConvertor.profileToProfileResponse(savedPlayer.getProfile());
    }
}
