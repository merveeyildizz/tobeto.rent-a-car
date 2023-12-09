package com.example.tobetorentacar.services.abstracts;

import com.example.tobetorentacar.services.dtos.requests.rental.AddRentalRequest;
import com.example.tobetorentacar.services.dtos.requests.rental.UpdateRentalRequest;
import com.example.tobetorentacar.services.dtos.responses.rental.GetRentalListResponse;
import com.example.tobetorentacar.services.dtos.responses.rental.GetRentalResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.util.List;

public interface RentalService {
    List<GetRentalListResponse> getAll();
    GetRentalResponse getById(int id);
    void add(AddRentalRequest request);
    void update(int id,UpdateRentalRequest updateRentalRequest);
    void delete(int id);
    List<GetRentalListResponse> findByDestination(String destination);
    List<GetRentalListResponse> findByRentalDateAfter(Date rentalDate);
    List<GetRentalListResponse> getAll2();
    List<GetRentalListResponse> orderByReturnDate();
}
