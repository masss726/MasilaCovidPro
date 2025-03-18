package com.Controller;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.Service.CovidDataServices;

@RestController
@RequestMapping("/Masila")
@Component
public class coraViruseController{
	
	//this for Word Result
	private final CovidDataServices service;
	
	public coraViruseController(CovidDataServices service) {
		super();
		this.service = service;
	}
	

	//http://localhost:8080/Masila/
	@GetMapping
    public RedirectView getCovidWorld(Model m) {
		System.out.println("World Detailes : "+service.getCovidDetailes());
		System.out.println("******************************");

        return new RedirectView("/indexHome.html");
    }
	
	//http://localhost:8080/Masila/country/India
	@GetMapping("/country/{count}")
	public Map<String,Object> getContryDatas(@PathVariable String count){
		System.out.println(count+" Detailes : "+service.getCovidDetailesByCuntry(count));
		System.out.println("*****************************");
		return service.getCovidDetailesByCuntry(count);
	}
	

}
