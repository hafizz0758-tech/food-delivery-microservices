package com.example.UserClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepo r;

    @PostMapping("/register")
    public User register(@RequestBody User u) {
        return r.save(u);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return r.findAll();
    }

    @PostMapping("/login")
    public User login(@RequestBody User u) {

        User user = r.findByEmail(u.getEmail());

        if (user != null && user.getPassword().equals(u.getPassword())) {
            return user;
        }

        return null;
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return r.findById(id).orElse(null);
    }
}