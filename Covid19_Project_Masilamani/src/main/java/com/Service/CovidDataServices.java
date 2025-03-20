package com.Service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class CovidDataServices {

    // Global COVID-19 data API URL
    private static final String GLOBAL_API_URL = "https://disease.sh/v3/covid-19/all";

    // Country-specific COVID-19 data API URL
    private static final String COUNTRY_API_URL = "https://disease.sh/v3/covid-19/countries/";

    private final RestTemplate restTemplate = new RestTemplate();

    // Fetch global COVID-19 statistics
    @SuppressWarnings("unchecked") 
    public Map<String, Object> getCovidDetails() {        
        try {
            return restTemplate.getForObject(GLOBAL_API_URL, Map.class);
        } catch (HttpClientErrorException e) {
            System.err.println("Error fetching global COVID data: " + e.getMessage());
            return Map.of("error", "Unable to fetch global COVID-19 data.");
        }
    }

    // Fetch COVID-19 statistics for a specific country
    @SuppressWarnings("unchecked")
    public Map<String, Object> getCovidDetailsByCountry(String country) {
        try {
            String urlForCountry = COUNTRY_API_URL + country;
            return restTemplate.getForObject(urlForCountry, Map.class);
        } catch (HttpClientErrorException e) {
            System.err.println("Error fetching COVID data for country: " + country + " - " + e.getMessage());
            return Map.of("error", "Unable to fetch COVID-19 data for " + country);
        }
    }
}
