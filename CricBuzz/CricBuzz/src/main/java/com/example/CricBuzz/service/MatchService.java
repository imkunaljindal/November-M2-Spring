package com.example.CricBuzz.service;

import com.example.CricBuzz.convertor.MatchConvertor;
import com.example.CricBuzz.dto.request.MatchRequest;
import com.example.CricBuzz.dto.request.TeamRequest;
import com.example.CricBuzz.dto.response.MatchResponse;
import com.example.CricBuzz.exception.TeamNotFoundException;
import com.example.CricBuzz.model.CricketMatch;
import com.example.CricBuzz.model.Team;
import com.example.CricBuzz.repository.CricketMatchRepository;
import com.example.CricBuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CricketMatchRepository matchRepository;

    public MatchResponse registerMatch(MatchRequest matchRequest, int teamAId, int teamBId) {
        Optional<Team> teamAOptional = teamRepository.findById(teamAId);
        Optional<Team> teamBOptional = teamRepository.findById(teamBId);
        if(teamAOptional.isEmpty() || teamBOptional.isEmpty()) {
            throw new TeamNotFoundException("One or more team id is not valid");
        }

        Team teamA = teamAOptional.get();
        Team teamB = teamBOptional.get();

        CricketMatch cricketMatch = MatchConvertor.matchRequestToMatch(matchRequest);
        cricketMatch.getTeams().add(teamA);
        cricketMatch.getTeams().add(teamB);

        teamA.getMatches().add(cricketMatch);
        teamB.getMatches().add(cricketMatch);

        CricketMatch savedMatch = matchRepository.save(cricketMatch);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConvertor.matchToMatchRespone(savedMatch);

    }
}
