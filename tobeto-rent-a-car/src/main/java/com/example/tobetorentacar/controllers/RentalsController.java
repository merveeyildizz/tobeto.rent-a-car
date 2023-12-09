package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.services.abstracts.RentalService;
import com.example.tobetorentacar.services.dtos.requests.rental.AddRentalRequest;
import com.example.tobetorentacar.services.dtos.requests.rental.UpdateRentalRequest;
import com.example.tobetorentacar.services.dtos.responses.rental.GetRentalListResponse;
import com.example.tobetorentacar.services.dtos.responses.rental.GetRentalResponse;
import com.example.tobetorentacar.entities.Rental;
import com.example.tobetorentacar.repositories.RentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalsController {
    private final RentalService rentalService;


    @GetMapping
    public List<GetRentalListResponse> getAll(){
        return this.rentalService.getAll();

    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id){
        return this.rentalService.getById(id);


    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest request){
        this.rentalService.add(request);


    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.rentalService.delete(id);


    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateRentalRequest updateRentalRequest){
        this.rentalService.update(id,updateRentalRequest);

    }

    @GetMapping("destination")
    public List<GetRentalListResponse> findByDestination(@RequestParam String destination){
        return this.rentalService.findByDestination(destination);
    }

    @GetMapping("findByRentalDateAfter")
    public List<GetRentalListResponse> findByRentalDateAfter(Date rentalDate){
        return this.rentalService.findByRentalDateAfter(rentalDate);
    }

    @GetMapping("getAll2")
    public List<GetRentalListResponse> getAll2(){
        return this.rentalService.getAll2();
    }


    @GetMapping("orderByReturnDate")
    public List<GetRentalListResponse> orderByReturnDate(){
        return this.rentalService.orderByReturnDate();
    }



}


