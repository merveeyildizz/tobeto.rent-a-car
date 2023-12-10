package com.example.tobetorentacar.services.dtos.responses.rental;

import com.example.tobetorentacar.services.dtos.responses.car.GetCarListResponse;
import com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentListResponse;
import com.example.tobetorentacar.services.dtos.responses.user.GetUserListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalListResponse {
    private int rentalNumber;

    private String destination;

    private Date rentalDate;

    private Date returnDate;

}
