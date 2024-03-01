package com.example.AssignmentDice.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    Coordinate coord;

    List<WeatherData> weather;

     private String base;
    Map<String,Double> main;
    private int visibility;
    Wind wind;
    private int dt;

    SysData sys;

    private int timezone;
    private int id;
    private String name;
    private int cod;


}