package com.example.RestaurantClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantClientApplication.class, args);
    }

}