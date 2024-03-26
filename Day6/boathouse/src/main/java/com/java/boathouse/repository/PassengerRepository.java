package com.java.boathouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.boathouse.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository <Passenger,String>
{
    
}
