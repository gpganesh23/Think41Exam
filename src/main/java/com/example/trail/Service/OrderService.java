package com.example.trail.Service;

import com.example.trail.Entity.Order;
import com.example.trail.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Method to find a specific order by its ID and the user's ID
    public Optional<Order> findOrderByUserIdAndOrderId(Long userId, Long orderId) {
        // The repository method is now findByIdAndUserId to reflect the column names.
        return orderRepository.findByIdAndUserId(orderId, userId);
    }
}