package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Controller","com.Service"})
public class Covid19ProjectMasilamaniApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19ProjectMasilamaniApplication.class, args);
	}

}
