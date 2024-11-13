package com.example.CricBuzz.dto.response;

import com.example.CricBuzz.model.enums.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PlayerResponse {

    String name;

    Speciality speciality;
}
