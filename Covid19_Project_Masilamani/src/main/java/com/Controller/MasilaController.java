package com.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasilaController {

    // Injecting Covid data service
    @Autowired
    private coraViruseController covidDatas; // Fixed class name format

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
}
