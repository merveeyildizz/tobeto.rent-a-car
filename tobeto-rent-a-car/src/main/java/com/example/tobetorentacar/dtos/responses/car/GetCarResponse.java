package com.example.tobetorentacar.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private int modelYear;
    private String color;
    private double rentPrice;
}
