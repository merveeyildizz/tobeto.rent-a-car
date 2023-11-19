package com.example.tobetorentacar.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
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
    private List<Rental> rentals;
}
