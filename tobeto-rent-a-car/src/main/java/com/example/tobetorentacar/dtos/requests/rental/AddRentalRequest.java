package com.example.tobetorentacar.dtos.requests.rental;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    private int rentalNumber;

    private String destination;

    private Date rentalDate;

    private Date returnDate;
}
