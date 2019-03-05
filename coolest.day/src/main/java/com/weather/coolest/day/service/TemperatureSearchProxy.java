package com.weather.coolest.day.service;

import com.weather.coolest.day.model.Temperature;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// Makes GET call to https://api.darksky.net with {APIKEY}/{lat},{longi} values, and returns response to DayWeatherServiceImpl.java

@FeignClient(name="temperatureSearch", url = "https://api.darksky.net")
public interface TemperatureSearchProxy {

   @RequestMapping(value = "/forecast/{APIKEY}/{lat},{longi}", method = RequestMethod.GET)
   public Object findByZipcode(@PathVariable(value="APIKEY") String APIKEY, @PathVariable(value="lat") Double lat, @PathVariable(value="longi") Double longi);

}
