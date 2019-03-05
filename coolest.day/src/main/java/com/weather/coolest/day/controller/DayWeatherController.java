package com.weather.coolest.day.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.weather.coolest.day.model.Temperature;
import com.weather.coolest.day.service.DayWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DayWeatherController {

    @Autowired
    DayWeatherService dayWeatherService;


    // Method receives zipcode in the path, from UI, and sends ResponseEntity with HttpStatus code

    @GetMapping("/hourlyweather/{zipcode}")
    public ResponseEntity<?> hourlyWeather(@PathVariable("zipcode") final Integer zipcode)
    {
        System.out.println("zipcode " + zipcode);
        Temperature temperature = dayWeatherService.getCoolestHour(zipcode);
        System.out.println(temperature);
        return new ResponseEntity<>(temperature, HttpStatus.OK);
    }

}

