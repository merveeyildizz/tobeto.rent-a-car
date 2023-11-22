package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.entities.Rental;
import com.example.tobetorentacar.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {
    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository){
        this.rentalRepository=rentalRepository;
    }

    @GetMapping
    public List<Rental> getAll(){

        return rentalRepository.findAll();
    }

    @GetMapping("{id}")
    public Rental getById(@PathVariable int id){

        return rentalRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Rental rental){

        rentalRepository.save(rental);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        rentalRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Rental uRental){
       Rental updateRental=rentalRepository.findById(id).orElseThrow();

       updateRental.setId(uRental.getId());
       updateRental.setRentalNumber(uRental.getRentalNumber());
       updateRental.setRentalDate(uRental.getRentalDate());
       updateRental.setDestination(uRental.getDestination());
       updateRental.setReturnDate(uRental.getReturnDate());


    }
}
