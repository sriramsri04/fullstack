package com.java.boathouse.service;

import java.util.List;
import java.util.Optional;

import com.java.boathouse.model.Booking;

public interface BookingService {

    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(String bookingId);
    Booking addBooking(Booking booking);
    Optional<Booking> updateBooking(String bookingId, Booking booking);
    void deleteBooking(String bookingId);
    
}
