package com.example.AssignmentDice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourlyWeather {

    int cod;
    int messagel;
    int cnt;

    List<DataList> list;

    City city;
}
