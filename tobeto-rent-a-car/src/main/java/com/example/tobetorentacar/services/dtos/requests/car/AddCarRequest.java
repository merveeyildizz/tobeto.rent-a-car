package com.example.tobetorentacar.services.dtos.requests.car;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private int modelYear;
    private String color;
    private double rentPrice;
}
