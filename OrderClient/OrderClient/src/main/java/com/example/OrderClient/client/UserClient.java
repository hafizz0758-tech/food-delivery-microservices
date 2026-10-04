package com.example.OrderClient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserClient")
public interface UserClient {

    @GetMapping("/users/{id}")
    Object getUser(@PathVariable int id);
}