package com.example.trail.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trail.Entity.User;
import com.example.trail.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/customers")
    public List<User> getAllCustomers() {
        return userService.findAllUsers();
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<?> getCustomerDetailsWithOrderCount(@PathVariable Long customerId) {
        if (customerId == null || customerId <= 0) {
            return ResponseEntity.badRequest().body("Invalid customer ID.");
        }
        
        return userService.findUserWithOrderCount(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
