package com.example.trail.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trail.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}