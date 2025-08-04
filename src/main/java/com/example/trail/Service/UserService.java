package com.example.trail.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trail.DTO.UserWithOrderCountDto;
import com.example.trail.Entity.User;
import com.example.trail.Repository.OrderRepository;
import com.example.trail.Repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public UserService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserWithOrderCountDto> findUserWithOrderCount(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Long orderCount = orderRepository.countByUserId(userId);
            UserWithOrderCountDto dto = new UserWithOrderCountDto(user, orderCount);
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }
}
