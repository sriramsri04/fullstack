package com.java.boathouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.boathouse.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository <Booking,String>
{
    
}
