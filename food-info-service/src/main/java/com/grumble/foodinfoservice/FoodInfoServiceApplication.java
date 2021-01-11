package com.grumble.foodinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class FoodInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodInfoServiceApplication.class, args);
	}

}
