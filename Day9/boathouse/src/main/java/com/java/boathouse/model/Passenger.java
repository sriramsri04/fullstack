package com.java.boathouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "_passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String passengerId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;


    @ManyToOne
    @JoinColumn(name = "bookingId", nullable= false)
    private Booking booking;

}
