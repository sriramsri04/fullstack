package com.java.boathouse.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.boathouse.model.Booking;
import com.java.boathouse.repository.BookingRepository;
import com.java.boathouse.service.BookingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{
    
    private final BookingRepository bookingRepository;
    
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(String bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> updateBooking(String bookingId, Booking updatedBooking) {
        Optional<Booking> existing = bookingRepository.findById(bookingId);
        if(existing.isPresent()){
            updatedBooking.setBookingId(bookingId);
            return Optional.of(bookingRepository.save(updatedBooking));
        }
        return Optional.empty();
    }

    @Override
    public void deleteBooking(String bookingId) {
       bookingRepository.deleteById(bookingId);
    }

    
} 
