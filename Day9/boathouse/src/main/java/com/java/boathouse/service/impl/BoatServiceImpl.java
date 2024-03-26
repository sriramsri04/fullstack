package com.java.boathouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.boathouse.model.Boat;
import com.java.boathouse.repository.BoatRepository;
import com.java.boathouse.service.BoatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoatServiceImpl implements BoatService{

    private final BoatRepository boatRepository;

    @Override
    public List<Boat> getAllBoats() {
        return boatRepository.findAll();
    }

    @Override
    public Optional<Boat> getBoatById(String bid) {
        return boatRepository.findById(bid);   
    }

    @Override
    public Boat addBoat(Boat boat) {
        return boatRepository.save(boat);
    }

    @Override
    public Optional<Boat> updateBoat(String bid, Boat updatedBoat) {
        Optional<Boat> existing = boatRepository.findById(bid);
        if(existing.isPresent()){
            updatedBoat.setBid(bid);
            return Optional.of(boatRepository.save(updatedBoat));
        }
        return Optional.empty();
    }

    @Override
    public void deleteBoat(String bid) {
        boatRepository.deleteById(bid);
    }
    
}
