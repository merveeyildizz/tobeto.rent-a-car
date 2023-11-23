package com.example.tobetorentacar.dtos.requests.payment;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {
    private int amount;
    private String paymentType;
}
