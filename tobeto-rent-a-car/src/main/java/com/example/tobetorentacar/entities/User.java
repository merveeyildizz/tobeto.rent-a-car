package com.example.tobetorentacar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name="phone_number")
    private int phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Rental> rentals;
}
