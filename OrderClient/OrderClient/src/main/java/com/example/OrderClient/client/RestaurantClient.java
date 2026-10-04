package com.example.OrderClient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RestaurantClient")
public interface RestaurantClient {

    @GetMapping("/restaurant/{id}")
    Object getRestaurant(@PathVariable int id);
}