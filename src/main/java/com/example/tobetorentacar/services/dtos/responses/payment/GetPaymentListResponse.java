package com.example.tobetorentacar.services.dtos.responses.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentListResponse {
    private int amount;
    private String paymentType;
}
