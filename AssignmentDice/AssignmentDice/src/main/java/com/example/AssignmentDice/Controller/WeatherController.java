package com.example.AssignmentDice.Controller;

import com.example.AssignmentDice.DTO.HourlyWeather;
import com.example.AssignmentDice.DTO.Weather;
import com.example.AssignmentDice.Exception.CustomErrorException;
import com.example.AssignmentDice.Service.WeatherAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherAPIService weatherAPIService;
    public WeatherController(WeatherAPIService weatherAPIService) {
        this.weatherAPIService = weatherAPIService;
    }

    @GetMapping(value="/{city}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Weather> getWeatherByCity(@PathVariable String city) throws IOException, InterruptedException {
        Weather weather = weatherAPIService.getWeatherByCity(city);
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/rapid/{city}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getWeatherByCityRapid(@PathVariable String city,@RequestHeader("X-RapidAPI-Key") String apiKey) throws IOException, InterruptedException {
        String weather = weatherAPIService.getWeatherByCityRapid(city,apiKey);
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/{city}/hourly",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HourlyWeather> getHourlyWeather(@PathVariable String city) {
        Weather weather = weatherAPIService.getWeatherByCity(city);

        if (weather != null) {
            double lat=weather.getCoord().getLat();
            double lon=weather.getCoord().getLon();
            HourlyWeather weather2 = weatherAPIService.getHourlyWeatherByCity(lat,lon);
            return new ResponseEntity<>(weather2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/rapid/{city}/hourly",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getHourlyWeatherByCityRapid(@PathVariable String city,@RequestHeader("X-RapidAPI-Key") String apiKey) throws IOException, InterruptedException {
        String weather = weatherAPIService.getHourlyWeatherByCityRapid(city,apiKey);
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            throw new CustomErrorException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Access denied for user",
                    weather
            );
        }
    }

    /*
    curl --location 'http://localhost:8080/weather/bengaluru' \
--header 'X-RapidAPI-Key: dc92efdd7cmsh3e155b84a35ef56p122e06jsnf085ccc022ea'
    */


}