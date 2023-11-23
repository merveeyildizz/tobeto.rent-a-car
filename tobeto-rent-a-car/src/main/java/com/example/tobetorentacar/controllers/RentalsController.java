package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.dtos.requests.rental.AddRentalRequest;
import com.example.tobetorentacar.dtos.requests.rental.UpdateRentalRequest;
import com.example.tobetorentacar.dtos.responses.rental.GetRentalListResponse;
import com.example.tobetorentacar.dtos.responses.rental.GetRentalResponse;
import com.example.tobetorentacar.dtos.responses.user.GetUserListResponse;
import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.entities.Rental;
import com.example.tobetorentacar.repositories.RentalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {
    private final RentalRepository rentalRepository;

    public RentalsController(RentalRepository rentalRepository){

        this.rentalRepository=rentalRepository;
    }

    @GetMapping
    public List<GetRentalListResponse> getAll(){
        List<Rental> rentalList= rentalRepository.findAll();
        List<GetRentalListResponse> rentalListResponses = new ArrayList<>();
        for(Rental rental: rentalList)
        {
            GetRentalListResponse dto= new GetRentalListResponse();
            dto.setRentalNumber(rental.getRentalNumber());
            dto.setDestination(rental.getDestination());
            dto.setRentalDate(rental.getRentalDate());
            dto.setReturnDate(rental.getReturnDate());
            rentalListResponses.add(dto);

        }
        return rentalListResponses;
    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id){

        Rental rental= rentalRepository.findById(id).orElseThrow();
        GetRentalResponse dto= new GetRentalResponse();
        dto.setDestination(rental.getDestination());
        dto.setRentalNumber(rental.getRentalNumber());
        dto.setRentalDate(rental.getRentalDate());
        dto.setReturnDate(rental.getReturnDate());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest request){
        Rental rental=new Rental();
        rental.setDestination(request.getDestination());
        rental.setRentalNumber(request.getRentalNumber());
        rental.setRentalDate(request.getRentalDate());
        rental.setReturnDate(request.getReturnDate());
        rentalRepository.save(rental);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        rentalRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateRentalRequest updateRentalRequest){
       Rental updateRental=rentalRepository.findById(id).orElseThrow();


       updateRental.setRentalNumber(updateRentalRequest.getRentalNumber());
       updateRental.setRentalDate(updateRentalRequest.getRentalDate());
       updateRental.setDestination(updateRentalRequest.getDestination());
       updateRental.setReturnDate(updateRentalRequest.getReturnDate());

       rentalRepository.save(updateRental);


    }
}
