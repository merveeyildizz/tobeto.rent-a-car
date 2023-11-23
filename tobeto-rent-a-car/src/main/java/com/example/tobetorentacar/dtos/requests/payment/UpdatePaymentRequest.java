package com.example.tobetorentacar.dtos.requests.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {
    private int amount;
    private String paymentType;
}
