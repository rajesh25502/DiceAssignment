package com.example.AssignmentDice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysData {

    int type;
    int id;
    String country;
    int sunrise;
    int sunset;

}
