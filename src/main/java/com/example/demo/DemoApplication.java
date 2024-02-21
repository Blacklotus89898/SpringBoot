package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// appliaction entry point
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

// add auth, uasecase folders, sorting, querying, delete, update, create mutiple tables with fk, migration, perform data sanitation