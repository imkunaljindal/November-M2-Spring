package com.example.CricBuzz.repository;

import com.example.CricBuzz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
