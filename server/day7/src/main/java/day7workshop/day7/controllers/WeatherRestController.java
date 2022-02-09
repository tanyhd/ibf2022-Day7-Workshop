package day7workshop.day7.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day7workshop.day7.services.WeatherService;

@RestController
@CrossOrigin
@RequestMapping(path="api/weather", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherRestController {

    @Autowired
    WeatherService weatherService;

    @GetMapping(path="{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeatherJson(city));
    }
    
    
}
