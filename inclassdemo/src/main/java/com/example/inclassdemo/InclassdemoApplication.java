package com.example.inclassdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InclassdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InclassdemoApplication.class, args);
	}

}
