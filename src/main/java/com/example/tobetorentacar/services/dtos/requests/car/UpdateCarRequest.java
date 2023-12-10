package com.example.tobetorentacar.services.dtos.requests.car;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private int modelYear;
    private String color;
    private double rentPrice;
}
