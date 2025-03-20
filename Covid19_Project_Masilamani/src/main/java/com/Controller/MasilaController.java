package com.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MasilaController {

    // Injecting Covid data service
    @Autowired
    private coraViruseController covidDatas; // Fixed class name format
    //http://localhost:8080/world
    @GetMapping("/world")
    public String getWorldData(Model model) {
        // Fetch COVID-19 world data from the API
        Map<String, Object> worldData = covidDatas.getCovidWorld();

        // Debugging: Print API response
        System.out.println("World Data from API: " + worldData);

        // Creating a new map to store and display COVID-19 details
        Map<String, Object> covidDetails = new LinkedHashMap<>();
        covidDetails.put("Total Cases", worldData.getOrDefault("cases", "N/A"));
        covidDetails.put("Active Cases", worldData.getOrDefault("active", "N/A"));
        covidDetails.put("Recovered Cases", worldData.getOrDefault("recovered", "N/A"));
        covidDetails.put("Deaths", worldData.getOrDefault("deaths", "N/A"));
        covidDetails.put("New Cases Today", worldData.getOrDefault("todayCases", "N/A"));
        covidDetails.put("New Deaths Today", worldData.getOrDefault("todayDeaths", "N/A"));
        covidDetails.put("Critical Cases", worldData.getOrDefault("critical", "N/A"));
        covidDetails.put("Cases Per Million", worldData.getOrDefault("casesPerOneMillion", "N/A"));

        // Debugging: Print structured data for Thymeleaf
        System.out.println("Formatted Covid Details: " + covidDetails);

        // Add data to the model for Thymeleaf
        model.addAttribute("covidDetails", covidDetails);

        return "indexHome"; // Thymeleaf template
    }

    // Country setup asdasdafsfsa
    @GetMapping("/MasilaCountry/{country}")
    public String getCountryData(@PathVariable String country, Model model) {
        // Fetch country-specific data from the service

        // Map country datas
        // sdfsdafsad
        Map<String, Object> countryData = covidDatas.getCountryData(country);

        // Debugging: Print API response
        System.out.println("Country Data for " + country + ": " + countryData);

        // Prepare data for the Thymeleaf template
        Map<String, Object> countryDetails = new LinkedHashMap<>();
        countryDetails.put("Country", country);
        countryDetails.put("Total Cases", countryData.getOrDefault("cases", "N/A"));
        countryDetails.put("Active Cases", countryData.getOrDefault("active", "N/A"));
        countryDetails.put("Recovered Cases", countryData.getOrDefault("recovered", "N/A"));
        countryDetails.put("Deaths", countryData.getOrDefault("deaths", "N/A"));
        countryDetails.put("New Cases Today", countryData.getOrDefault("todayCases", "N/A"));
        countryDetails.put("New Deaths Today", countryData.getOrDefault("todayDeaths", "N/A"));
        countryDetails.put("Critical Cases", countryData.getOrDefault("critical", "N/A"));

        // Add data to the model
        model.addAttribute("countryDetails", countryDetails);

        return "contryDatas"; // Thymeleaf template for displaying country data
    }
}
