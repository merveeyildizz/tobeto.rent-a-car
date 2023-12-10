package com.example.tobetorentacar.services.dtos.requests.payment;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentRequest {
    @NotNull(message = "Tutar boş olamaz")
    private int amount;

    @NotBlank(message = "Ödeme tipi boş geçilemez")
    @Size(min = 3,max = 20, message = "Ödeme tipi 3 ile 20 hane arasında olmalıdır")
    private String paymentType;
}
