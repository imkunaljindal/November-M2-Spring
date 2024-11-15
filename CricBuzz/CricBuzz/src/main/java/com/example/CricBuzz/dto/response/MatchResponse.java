package com.example.CricBuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MatchResponse {

    String title;

    String venue;

    int noOfOvers;

    Date createdAt;

    List<TeamResponse> teams;
}
