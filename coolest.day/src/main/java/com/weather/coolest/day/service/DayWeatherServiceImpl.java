package com.weather.coolest.day.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.coolest.day.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

@Service
public class DayWeatherServiceImpl implements DayWeatherService {

    @Autowired
    TemperatureSearchProxy temperatureSearchProxy;

    // Calculates coolest hour in the day for {zipcode}

    @Override
    public Temperature getCoolestHour(int zipcode) {

        try
        {

            Object object = temperatureSearchProxy.findByZipcode("98c75b2e1b1f6688566b550dd0237489", 37.8267,-122.4233);
            // store this response in db.
            // if next request is within 1 minutes, fetch response from db and send the data to the UI
            //        return new ();Temperature
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.valueToTree(object.toString());



            // call
            HashMap<Integer, Float> hourlyTemperature = generateDummyHoursAndTemperatures();

            // Sort hourlyTemperature by values.

            LinkedHashMap<Integer, Float> result = hourlyTemperature
                    .entrySet()
                    .stream()
                    .sorted(comparingByValue())
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                    LinkedHashMap::new));

            // get firsyKey
            Integer firstKey = result.keySet().stream().findFirst().get();

            // get firstValue
            Float firstValue = result.values().stream().findFirst().get();

            // concatenate hour and temperature and return to controller
            Temperature temperature = new Temperature(firstValue, firstKey);
            return temperature;

        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }


    }



    // Method Generates dummy data
    // CREATING DUMMY DATA IN HASHMAP. HOURS AS INTEGER AND DOUBLE AS TEMPERATURE


    public HashMap<Integer, Float> generateDummyHoursAndTemperatures()
    {


        HashMap<Integer, Float> hourlyTemperature = new HashMap<>();
        hourlyTemperature.put(1,61.5f);
        hourlyTemperature.put(2,62.5f);
        hourlyTemperature.put(3,63.5f);
        hourlyTemperature.put(4,64.5f);
        hourlyTemperature.put(5,65.5f);
        hourlyTemperature.put(6,66.5f);
        hourlyTemperature.put(7,67.5f);
        hourlyTemperature.put(8,68.5f);
        hourlyTemperature.put(9,69.5f);
        hourlyTemperature.put(10,70.5f);
        hourlyTemperature.put(11,15.5f);
        hourlyTemperature.put(12,25.5f);
        hourlyTemperature.put(13,35.5f);
        hourlyTemperature.put(14,45.5f);
        hourlyTemperature.put(15,55.5f);
        hourlyTemperature.put(16,65.5f);
        hourlyTemperature.put(17,75.5f);
        hourlyTemperature.put(18,85.5f);
        hourlyTemperature.put(19,95.5f);
        hourlyTemperature.put(20,65.1f);
        hourlyTemperature.put(21,65.2f);
        hourlyTemperature.put(22,65.3f);
        hourlyTemperature.put(23,65.4f);
        hourlyTemperature.put(24,65.5f);

        return hourlyTemperature;
    }
}
