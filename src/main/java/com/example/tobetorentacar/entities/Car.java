package com.example.tobetorentacar.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private double rentPrice;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Rental> rentals;
}
