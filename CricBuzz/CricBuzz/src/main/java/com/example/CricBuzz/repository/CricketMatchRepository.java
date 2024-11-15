package com.example.CricBuzz.repository;

import com.example.CricBuzz.model.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketMatchRepository extends JpaRepository<CricketMatch,Integer> {
}
