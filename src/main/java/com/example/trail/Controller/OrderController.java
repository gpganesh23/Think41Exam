
package com.example.trail.Controller;

import com.example.trail.Entity.Order;
import com.example.trail.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Endpoint to get a specific order for a specific customer
    @GetMapping("/customers/{customerId}/orders/{orderId}")
    public ResponseEntity<Order> getOrderByCustomerAndOrderId(@PathVariable Long customerId, @PathVariable Long orderId) {
        // Validate input
        if (customerId == null || customerId <= 0 || orderId == null || orderId <= 0) {
            return ResponseEntity.badRequest().build();
        }

        // Use the service to find the order
        Optional<Order> orderOptional = orderService.findOrderByUserIdAndOrderId(customerId, orderId);

        // Return the response
        return orderOptional.map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
}
