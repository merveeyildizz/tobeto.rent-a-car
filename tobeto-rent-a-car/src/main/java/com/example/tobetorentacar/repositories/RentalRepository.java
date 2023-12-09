package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.Rental;
import com.example.tobetorentacar.services.dtos.responses.rental.GetRentalListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
    List<Rental> findByDestination(String destination);
    List<Rental> findByRentalDateAfter(Date rentalDate);

    @Query("Select new com.example.tobetorentacar.services.dtos.responses.rental" +
            ".GetRentalListResponse(r.rentalNumber,r.destination,r.rentalDate,r.returnDate) " +
            "From Rental r")
    List<GetRentalListResponse> getAll2();

    @Query("Select new com.example.tobetorentacar.services.dtos.responses.rental." +
            "GetRentalListResponse(r.rentalNumber,r.destination,r.rentalDate,r.returnDate) " +
            "From Rental r Order By r.returnDate ASC")
    List<GetRentalListResponse> orderByReturnDate();




}
