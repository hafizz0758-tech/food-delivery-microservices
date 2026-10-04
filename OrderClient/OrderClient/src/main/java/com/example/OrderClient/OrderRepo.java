package com.example.OrderClient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    List<Order> findByUserId(int userId);

}