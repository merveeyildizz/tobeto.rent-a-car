package com.example.tobetorentacar.dtos.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private String name;

    private String surname;

    private String email;

    private int phoneNumber;

    private String address;
}
