package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
