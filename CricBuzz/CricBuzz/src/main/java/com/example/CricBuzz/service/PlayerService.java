package com.example.CricBuzz.service;

import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player addPlayer(Player player) {
        Player savedPlayer = playerRepository.save(player);
        return savedPlayer;
    }
}
