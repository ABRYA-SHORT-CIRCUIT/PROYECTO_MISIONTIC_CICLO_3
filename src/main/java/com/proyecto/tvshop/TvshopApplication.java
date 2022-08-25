package com.proyecto.tvshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class TvshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TvshopApplication.class, args);
	}

}
