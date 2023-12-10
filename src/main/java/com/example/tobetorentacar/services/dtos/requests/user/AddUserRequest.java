package com.example.tobetorentacar.services.dtos.requests.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    @NotBlank(message = "İsim boş geçilemez")
    @Size(min = 2,max = 20,message = "İsim 2 ile 20 hane arasında olmalıdır")
    private String name;

    @NotBlank(message = "Soyisim boş geçilemez")
    @Size(min = 2,max = 20,message = "Soyisim 2 ile 20 hane arasında olmalıdır")
    private String surname;

    @Email(message = "Hatalı e-mail girişi yapılmıştır")
    private String email;


    @NotNull(message = "Telefon numarası boş geçilemez ")
    private int phoneNumber;

    @NotBlank(message = "İsim boş geçilemez")
    @Size(min = 2,max = 99)
    private String address;
}
