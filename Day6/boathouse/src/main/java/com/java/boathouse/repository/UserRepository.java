package com.java.boathouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.boathouse.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);

    
} 

    

