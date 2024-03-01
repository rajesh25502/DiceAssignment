package com.example.AssignmentDice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    Map<String,String> location;
    Coordinate coordinates;
}
