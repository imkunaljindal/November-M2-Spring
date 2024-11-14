package com.example.CricBuzz.convertor;

import com.example.CricBuzz.dto.request.PlayerRequest;
import com.example.CricBuzz.dto.request.ProfileRequest;
import com.example.CricBuzz.dto.response.PlayerResponse;
import com.example.CricBuzz.dto.response.ProfileResponse;
import com.example.CricBuzz.model.PlayerProfile;

public class ProfileConvertor {

    public static PlayerProfile profileRequstToProfile(ProfileRequest profileRequest) {
        return PlayerProfile.builder()
                .runsScored(profileRequest.getRunsScored())
                .wicketsTaken(profileRequest.getWicketsTaken())
                .battingAvg(profileRequest.getBattingAvg())
                .bowlingAvg(profileRequest.getBowlingAvg())
                .build();
    }

    public static ProfileResponse profileToProfileResponse(PlayerProfile playerProfile) {
        return ProfileResponse.builder()
                .runsScored(playerProfile.getRunsScored())
                .wicketsTaken(playerProfile.getWicketsTaken())
                .battingAvg(playerProfile.getBattingAvg())
                .bowlingAvg(playerProfile.getBowlingAvg())
                .player(PlayerConvertor.playerToPlayerResponse(playerProfile.getPlayer()))
                .build();
    }
}
