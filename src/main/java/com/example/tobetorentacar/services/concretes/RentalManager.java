package com.example.tobetorentacar.services.concretes;

import com.example.tobetorentacar.entities.Rental;
import com.example.tobetorentacar.repositories.RentalRepository;
import com.example.tobetorentacar.services.abstracts.RentalService;
import com.example.tobetorentacar.services.dtos.requests.rental.AddRentalRequest;
import com.example.tobetorentacar.services.dtos.requests.rental.UpdateRentalRequest;
import com.example.tobetorentacar.services.dtos.responses.rental.GetRentalListResponse;
import com.example.tobetorentacar.services.dtos.responses.rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    @Override
    public List<GetRentalListResponse> getAll() {
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

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental= rentalRepository.findById(id).orElseThrow();
        GetRentalResponse dto= new GetRentalResponse();
        dto.setDestination(rental.getDestination());
        dto.setRentalNumber(rental.getRentalNumber());
        dto.setRentalDate(rental.getRentalDate());
        dto.setReturnDate(rental.getReturnDate());
        return dto;
    }

    @Override
    public void add(AddRentalRequest request) {
        if(rentalRepository.existsByRentalNumber(request.getRentalNumber())){
            throw new RuntimeException("Kiralama numarası tekrar edemez");
        }
        Rental rental=new Rental();
        rental.setDestination(request.getDestination());
        rental.setRentalNumber(request.getRentalNumber());
        rental.setRentalDate(request.getRentalDate());
        rental.setReturnDate(request.getReturnDate());
        rentalRepository.save(rental);

    }


    @Override
    public void update(int id, UpdateRentalRequest updateRentalRequest) {
        Rental updateRental=rentalRepository.findById(id).orElseThrow();


        updateRental.setRentalNumber(updateRentalRequest.getRentalNumber());
        updateRental.setRentalDate(updateRentalRequest.getRentalDate());
        updateRental.setDestination(updateRentalRequest.getDestination());
        updateRental.setReturnDate(updateRentalRequest.getReturnDate());

        rentalRepository.save(updateRental);

    }

    @Override
    public void delete(int id) {
        rentalRepository.deleteById(id);

    }

    @Override
    public List<GetRentalListResponse> findByDestination(String destination) {
        List<Rental> rentals=rentalRepository.findByDestination(destination);
        List<GetRentalListResponse> response=new ArrayList<>();
        for(Rental rental:rentals){
            GetRentalListResponse dto=new GetRentalListResponse();
            dto.setDestination(rental.getDestination());
            dto.setRentalDate(rental.getRentalDate());
            dto.setRentalNumber(rental.getRentalNumber());
            dto.setReturnDate(rental.getReturnDate());
            response.add(dto);
        }
        return response;
    }

    @Override
    public List<GetRentalListResponse> findByRentalDateAfter(Date rentalDate) {
        List<Rental> rentals=rentalRepository.findByRentalDateAfter(rentalDate);
        List<GetRentalListResponse> response=new ArrayList<>();
        for(Rental rental:rentals){
            GetRentalListResponse dto=new GetRentalListResponse();
            dto.setReturnDate(rental.getReturnDate());
            dto.setRentalDate(rental.getRentalDate());
            dto.setRentalNumber(rental.getRentalNumber());
            dto.setDestination(rental.getDestination());
            response.add(dto);
        }
        return response;
    }

    @Override
    public List<GetRentalListResponse> getAll2() {
        return rentalRepository.getAll2();
    }

    @Override
    public List<GetRentalListResponse> orderByReturnDate() {
        return rentalRepository.orderByReturnDate();
    }
}
