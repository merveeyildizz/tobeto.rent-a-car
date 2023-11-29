package com.example.tobetorentacar.services.dtos.requests.user;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    private String name;

    private String surname;

    private String email;

    private int phoneNumber;

    private String address;
}
