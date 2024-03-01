package com.example.AssignmentDice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataList {

    int dt;
    Map<String,Double> main;
    List<WeatherData> weather;
    Map<String,Integer> clouds;
    Wind wind;

    int visibility;
    double pop;
    Map<String,String> sys;

    String dt_txt;

}
