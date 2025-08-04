package com.example.trail.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trail.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
   
    Long countByUserId(Long userId);
    
    List<Order> findByUserId(Long userId);

    Optional<Order> findByIdAndUserId(Long id, Long userId);
}