package com.example.tobetorentacar.services.dtos.responses.payment;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentResponse {
    private int amount;
    private String paymentType;
}
