package com.example.tobetorentacar.services.dtos.responses.car;

import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int modelYear;
    private String color;
    private double rentPrice;
    private GetBrandListResponse brand;


}
