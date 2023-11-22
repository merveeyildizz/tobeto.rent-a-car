package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {

}
