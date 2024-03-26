package com.java.boathouse.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Table(name="_payment")
public class Payment {
    
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     
     private long paymentid;
     private String status;
     private Double amountPaid;

}