package com.example.tobetorentacar.services.dtos.requests.car;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @NotNull(message = "Model yılı boş olamaz")
    private int modelYear;

    @NotBlank(message = "Renk boş olamaz")
    @Size(min=3, max = 20, message = "Renk adı 3 ile 20 hane arasında olmalıdır")
    private String color;


    @NotNull(message = "Kiralama ücreti boş olamaz")
    private double rentPrice;
}
