package com.example.tobetorentacar.services.dtos.requests.rental;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    @NotNull
    @Min(value = 1,message = "Kiralama numarası 1'den küçük olamaz")
    private int rentalNumber;

    @NotBlank(message = "Varış yeri boş olamaz")
    @Size(min = 3,max = 20,message = "3 ile 20 hane arasında olmalıdır")
    private String destination;


    @FutureOrPresent(message = "Kiralama tarihi bugün ya da sonraki bir tarih olmalıdır")
    private Date rentalDate;

    @Future(message = "Geri dönüş tarihi ileri bir tarih olmalıdır")
    private Date returnDate;
}
