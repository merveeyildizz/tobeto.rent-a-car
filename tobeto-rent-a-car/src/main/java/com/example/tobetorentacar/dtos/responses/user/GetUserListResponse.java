package com.example.tobetorentacar.dtos.responses.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListResponse {
    private String name;

    private String surname;

    private String email;

    private int phoneNumber;

    private String address;
}
