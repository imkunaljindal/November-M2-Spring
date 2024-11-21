package com.example.CricBuzz.controller;

import com.example.CricBuzz.dto.request.MatchRequest;
import com.example.CricBuzz.exception.TeamNotFoundException;
import com.example.CricBuzz.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/match")
@RequiredArgsConstructor
public class MatchController {
    
    final MatchService matchService;

//    public MatchController(MatchService matchService) {
//        this.matchService = matchService;
//    }

    @PostMapping
    public ResponseEntity registerMatch(@RequestBody MatchRequest matchRequest,
                                        @RequestParam("teamA-id") int teamAId,
                                        @RequestParam("teamB-id") int teamBId) {

        try{
         return new ResponseEntity<>(matchService.registerMatch(matchRequest,teamAId, teamBId),
                 HttpStatus.CREATED);
        }catch (TeamNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
