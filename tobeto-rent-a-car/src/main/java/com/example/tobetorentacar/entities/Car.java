package com.example.tobetorentacar.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "color")
    private String color;

    @Column(name = "rent_price")
    private int rentPrice;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;
}
