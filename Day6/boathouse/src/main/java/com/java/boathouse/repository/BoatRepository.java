package com.java.boathouse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.boathouse.model.Boat;

@Repository
public interface BoatRepository extends JpaRepository <Boat,String>
{
    
}
