package com.example.RestaurantClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    FoodRepo r;

    @PostMapping("/addfood")
    public Food addFood(@RequestBody Food f) {
        return r.save(f);
    }

    @GetMapping("/foods")
    public List<Food> getFoods() {
        return r.findAll();
    }

    @GetMapping("/food/{id}")
    public Food getFood(@PathVariable int id) {
        return r.findById(id).orElse(null);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getRestaurantFoods(
            @PathVariable int restaurantId) {

        return r.findByRestaurantId(restaurantId);
    }
}