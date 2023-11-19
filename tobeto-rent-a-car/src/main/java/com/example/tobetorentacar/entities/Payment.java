package com.example.tobetorentacar.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "payment_type")
    private String paymentType;


    @OneToMany(mappedBy = "payment")
    private List<Rental> rentals;
}
