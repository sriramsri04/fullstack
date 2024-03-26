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
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name="_boat")
public class Boat {
    
     @Id
     @GeneratedValue(strategy=GenerationType.UUID)
     
     private String bid;
     private String boatImageUrl;
     private String boatName;
     private String boatLocation;
     private String boatAvailableStatus;
     private String boatCategory;
     private String price;
     private String capacity;
}