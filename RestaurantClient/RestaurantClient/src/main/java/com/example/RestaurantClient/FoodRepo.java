package com.example.RestaurantClient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Integer> {

    List<Food> findByRestaurantId(int restaurantId);

}