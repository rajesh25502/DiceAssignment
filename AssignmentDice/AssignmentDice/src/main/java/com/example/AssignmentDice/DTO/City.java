package com.example.AssignmentDice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    int id;
    String name;
    Coordinate coord;
    String country;
    int population;
    int timezone;
    int sunrise;
    int sunset;
}
