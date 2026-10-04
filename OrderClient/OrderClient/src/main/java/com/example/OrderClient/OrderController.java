package com.example.OrderClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.OrderClient.client.RestaurantClient;
import com.example.OrderClient.client.UserClient;

@RestController
public class OrderController {

    @Autowired
    OrderRepo r;
    
    @Autowired
    UserClient uc;
    
    @Autowired
    RestaurantClient rc;
    


    @PostMapping("/placeorder")
    public Order placeOrder(@RequestBody Order o) {

        Object user = uc.getUser(o.getUserId());

        if (user == null) {
            return null;
        }

        o.setStatus("PLACED");

        return r.save(o);
    }
 

    @GetMapping("/orders")
    public List<Order> getOrders() {

        return r.findAll();
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable int id) {

        return r.findById(id).orElse(null);
    }

    @GetMapping("/user/{userId}/orders")
    public List<Order> getUserOrders(
            @PathVariable int userId) {

        return r.findByUserId(userId);
    }
    @GetMapping("/checkuser/{id}")
    public Object checkUser(@PathVariable int id) {
        return uc.getUser(id);
    }
    @GetMapping("/checkrestaurant/{id}")
    public Object checkRestaurant(@PathVariable int id) {
        return rc.getRestaurant(id);
    }
    @PutMapping("/order/{id}/status")
    public Order updateStatus(@PathVariable int id, @RequestParam String status) {

        Order o = r.findById(id).orElse(null);

        if (o != null) {
            o.setStatus(status);
            return r.save(o);
        }

        return null;
    }
 
}