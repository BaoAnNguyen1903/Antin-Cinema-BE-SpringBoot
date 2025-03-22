package com.example.antin_cinema_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.example.antin_cinema.model.entity" })
public class AntinCinemaBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(AntinCinemaBackendApplication.class, args);
	}

}
