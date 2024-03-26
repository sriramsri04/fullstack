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

import com.java.boathouse.model.Passenger;
import com.java.boathouse.service.PassengerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("boathouse/api/v1/passenger")
public class PassengerController {
    
    private final PassengerService passengerService;

    
    @GetMapping("/getPassengers")
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        List<Passenger> passengers = passengerService.getAllPassengers();
        return ResponseEntity.ok(passengers);
    }

    @GetMapping("/getPassengerById/{passengerId}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable String passengerId){

        Optional<Passenger> passenger = passengerService.getPassengerById(passengerId);
        return passenger.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addPassenger")
    public ResponseEntity<Passenger> addPassenger (@RequestBody Passenger passenger){
        Passenger createdPassenger = passengerService.addPassenger(passenger);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPassenger);
    }

    @DeleteMapping("/deletePassenger/{passengerId}")
    public ResponseEntity<String> deletePassenger(@PathVariable String passengerId){
        passengerService.deletePassenger(passengerId);
        return ResponseEntity.ok("Passenger data deleted successfully");
    }

    @PutMapping("/updatePassenger/{passengerId}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable String passengerId, @RequestBody Passenger passenger){
        var updatedPassenger =passengerService.updatePassenger(passengerId, passenger);
        return updatedPassenger.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
