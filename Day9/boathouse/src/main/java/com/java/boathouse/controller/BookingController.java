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

import com.java.boathouse.model.Booking;
import com.java.boathouse.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("boathouse/api/v1/bookings")
public class BookingController {

      private final BookingService bookingService;

    @GetMapping("/getBookings")
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/getBookingById/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String bookingId){

        Optional<Booking> booking = bookingService.getBookingById(bookingId);
        return booking.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addBooking")
    public ResponseEntity<Booking> addBooking (@RequestBody Booking booking){
        Booking createdBooking = bookingService.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @DeleteMapping("/deleteBooking/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable String bookingId){
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking data deleted successfully");
    }

    @PutMapping("/updateBooking/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable String bookingId, @RequestBody Booking booking){
        var updatedBooking =bookingService.updateBooking(bookingId, booking);
        return updatedBooking.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
