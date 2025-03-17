package com.Service;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Component
public class CovidDataServices {
	//It is all Datas
	private final String Main_url="https://disease.sh/v3/covid-19/all";
	//It is Select By Cuntry
	private final String API_URL = "https://disease.sh/v3/covid-19/countries/";
	
	//it is used to worldRecords
	@SuppressWarnings("unchecked") 
	public Map<String,Object> getCovidDetailes(){		
		RestTemplate MainDatas=new RestTemplate();
		return MainDatas.getForObject(Main_url,Map.class);
		
	}
	
//it is use to select Cuntry
	@SuppressWarnings("unchecked")
	public Map<String,Object> getCovidDetailesByCuntry(String contry){
		RestTemplate MainDatas=new RestTemplate();
		 String urlForCountry = API_URL + contry;
	        return MainDatas.getForObject(urlForCountry, Map.class);
	}
}
