package com.Controller;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.CovidDataServices;

@RestController
@RequestMapping("/Masila")
@Component
public class coraViruseController {

    // Inject Covid Data Service
    private final CovidDataServices service;

    public coraViruseController(CovidDataServices service) {
        this.service = service;
    }

    // Fetch global COVID-19 data
    @GetMapping
    public Map<String, Object> getCovidWorld() {
        Map<String, Object> covidData = service.getCovidDetails();
        
        // Debugging output
        System.out.println("Fetched World Data: " + covidData);
        System.out.println("******************************");

        return covidData;
    }

    // Fetch COVID-19 data for a specific country
    @GetMapping("/country/{country}")
    public Map<String, Object> getCountryData(@PathVariable String country) {
        Map<String, Object> countryData = service.getCovidDetailsByCountry(country);
        
        // Debugging output
        System.out.println(country + " COVID Data: " + countryData);
        System.out.println("******************************");

        return countryData;
    }
}
