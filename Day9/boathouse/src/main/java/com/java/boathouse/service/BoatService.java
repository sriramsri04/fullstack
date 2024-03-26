package com.java.boathouse.service;

import java.util.List;
import java.util.Optional;

import com.java.boathouse.model.Boat;


// @Service
public interface BoatService {

    List<Boat> getAllBoats();
    Optional<Boat> getBoatById(String bid);
    Boat addBoat(Boat boat);
    Optional<Boat> updateBoat(String bid, Boat boat);
    void deleteBoat(String bid);

}
