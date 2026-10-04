package com.example.RestaurantClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantRepo r;

    @PostMapping("/addrestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return r.save(restaurant);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return r.findAll();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        return r.findById(id).orElse(null);
    }

    @PutMapping("/editrestaurant/{id}")
    public Restaurant editRestaurant(@PathVariable int id,
                                     @RequestBody Restaurant restaurant) {

        Restaurant old = r.findById(id).orElse(null);

        if (old != null) {

            old.setName(restaurant.getName());
            old.setLocation(restaurant.getLocation());
            old.setType(restaurant.getType());

            return r.save(old);
        }

        return null;
    }

    @DeleteMapping("/deleterestaurant/{id}")
    public String deleteRestaurant(@PathVariable int id) {

        r.deleteById(id);

        return "Restaurant deleted successfully";
    }
}