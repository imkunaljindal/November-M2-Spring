package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.PlayerConvertor;
import com.example.CricBuzz.dto.request.PlayerRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.enums.Speciality;
import com.example.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        Player player = PlayerConvertor.playerRequestToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);
        return PlayerConvertor.playerToPlayerResponse(savedPlayer);
    }

    public List<PlayerResponse> getAllByAgeGreaterThan(int age) {

        List<Player> players = playerRepository.findByAgeGreaterThanEqual(age);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }

        return playerResponses;
    }

    public List<PlayerResponse> getAllByAgeGreaterThanAndSpeciality(int age, Speciality speciality) {
        List<Player> players = playerRepository.getAllByAgeGreaterThanAndSpeciality(age,speciality);
        List<PlayerResponse> playerResponses = new ArrayList<>();
        for(Player player: players) {
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }

        return playerResponses;
    }
}
