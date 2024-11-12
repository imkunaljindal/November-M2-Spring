package com.example.CricBuzz.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CricketMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    String venue;

    int noOfOvers;

    @CreationTimestamp
    Date createdAt;

    @ManyToMany
    @JoinTable(name = "team_match",
    joinColumns = @JoinColumn(name="cricket_match_id"),
    inverseJoinColumns = @JoinColumn(name = "team_id"))
    List<Team> teams;
}
