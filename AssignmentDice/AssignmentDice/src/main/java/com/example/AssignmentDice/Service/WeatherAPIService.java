package com.example.AssignmentDice.Service;



import com.example.AssignmentDice.DTO.HourlyWeather;
import com.example.AssignmentDice.DTO.Weather;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherAPIService {

    private final RestTemplate restTemplate;

    public WeatherAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Weather getWeatherByCity(String city) {
        String apiKey = "05421eb90beaae51378b287142ff8554";

        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        ResponseEntity<Weather> response = restTemplate.getForEntity(url, Weather.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            // Handle errors
            return null;
        }
    }

    public String getWeatherByCityRapid(String city,String apiKey) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/summary/"))
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            // Handle errors
            return null;
        }
    }

    public HourlyWeather getHourlyWeatherByCity(Double lat,Double lon) {
        String apiKey = "05421eb90beaae51378b287142ff8554";

        String url = "https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon+"&appid="+apiKey;

        ResponseEntity<HourlyWeather> response = restTemplate.getForEntity(url, HourlyWeather.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            // Handle errors
            return null;
        }
    }
    public String getHourlyWeatherByCityRapid(String city,String apiKey) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://forecast9.p.rapidapi.com/rapidapi/forecast/"+city+"/hourly/"))
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            // Handle errors
            return null;
        }
    }
}