package com.java.boathouse.service;

import java.util.List;
import java.util.Optional;

import com.java.boathouse.model.Passenger;

public interface PassengerService {

     List<Passenger> getAllPassengers();
    Optional<Passenger> getPassengerById(String passengerId);
    Passenger addPassenger(Passenger passenger);
    Optional<Passenger> updatePassenger(String passengerId, Passenger passenger);
    void deletePassenger(String passengerId);
    
}
