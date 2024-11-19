package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.PlayerConvertor;
import com.example.CricBuzz.dto.request.PlayerRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.exception.PlayerNotFoundException;
import com.example.CricBuzz.model.Player;
import com.example.CricBuzz.model.enums.Speciality;
import com.example.CricBuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        Player player = PlayerConvertor.playerRequestToPlayer(playerRequest);
        Player savedPlayer = playerRepository.save(player);
        sendEmail(savedPlayer);
        return PlayerConvertor.playerToPlayerResponse(savedPlayer);
    }

    private void sendEmail(Player player) {

        String text = "Congrats!!" + player.getName() + ". You have been registered on our cricbuzz portal" +
                ". Your speciality is " + player.getSpeciality();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("acciojobspring@gmail.com");
        message.setTo(player.getEmail());
        message.setSubject("Registration successfull");
        message.setText(text);
        javaMailSender.send(message);

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

    public Player getPlayer(int playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if(playerOptional.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player id");
        }

        return playerOptional.get();
    }
}
