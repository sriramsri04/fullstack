package com.java.boathouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.boathouse.model.Passenger;
import com.java.boathouse.repository.PassengerRepository;
import com.java.boathouse.service.PassengerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService{

    private final PassengerRepository passengerRepository;

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Optional<Passenger> getPassengerById(String passengerId) {
        return passengerRepository.findById(passengerId);
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Optional<Passenger> updatePassenger(String passengerId, Passenger updatedPassenger) {
        Optional<Passenger> existing = passengerRepository.findById(passengerId);
        if(existing.isPresent()){
            updatedPassenger.setPassengerId(passengerId);
            return Optional.of(passengerRepository.save(updatedPassenger));
        }
        return Optional.empty();
    }

    @Override
    public void deletePassenger(String passengerId) {
        passengerRepository.deleteById(passengerId);
    }
    
}
