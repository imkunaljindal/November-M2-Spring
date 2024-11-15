package com.example.CricBuzz.convertor;

import com.example.CricBuzz.dto.request.TeamRequest;
import com.example.CricBuzz.dto.response.TeamResponse;
import com.example.CricBuzz.model.Team;

public class TeamConvertor {

    public static Team teamRequestToTeam(TeamRequest teamRequest) {
        return Team.builder()
                .name(teamRequest.getName())
                .ranking(teamRequest.getRanking())
                .iccPoints(teamRequest.getIccPoints())
                .coach(teamRequest.getCoach())
                .build();
    }

    public static TeamResponse teamToTeamResponse(Team team) {
        return TeamResponse.builder()
                .name(team.getName())
                .ranking(team.getRanking())
                .coach(team.getCoach())
                .build();
    }
}
