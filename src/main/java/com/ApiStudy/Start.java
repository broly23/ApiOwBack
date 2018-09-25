package com.ApiStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableCaching
@SpringBootApplication
@ComponentScan ("com.ApiStudy")
public class Start {

	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	
	}

}
