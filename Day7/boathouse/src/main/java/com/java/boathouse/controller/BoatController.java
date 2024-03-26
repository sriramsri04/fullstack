package com.java.boathouse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.boathouse.model.Boat;
import com.java.boathouse.service.BoatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("boathouse/api/v1/boats")
public class BoatController {

    private final BoatService boatService;

    @GetMapping("/getBoats")
    public ResponseEntity<List<Boat>> getAllBoats(){
        List<Boat> boats = boatService.getAllBoats();
        return ResponseEntity.ok(boats);
    }

    @GetMapping("/getBoatById/{bid}")
    public ResponseEntity<Boat> getBoatById(@PathVariable String bid){

        Optional<Boat> boat = boatService.getBoatById(bid);
        return boat.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addBoat")
    public ResponseEntity<Boat> addBoat (@RequestBody Boat boat){
        Boat createdBoat = boatService.addBoat(boat);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBoat);
    }

    @DeleteMapping("/deleteBoat/{bid}")
    public ResponseEntity<String> deleteBoat(@PathVariable String bid){
        boatService.deleteBoat(bid);
        return ResponseEntity.ok("Boat data deleted successfully");
    }

    @PutMapping("/updateBoat/{bid}")
    public ResponseEntity<Boat> updateBoat(@PathVariable String bid, @RequestBody Boat boat){
        var updatedBoat =boatService.updateBoat(bid,boat);
        return updatedBoat.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
}
