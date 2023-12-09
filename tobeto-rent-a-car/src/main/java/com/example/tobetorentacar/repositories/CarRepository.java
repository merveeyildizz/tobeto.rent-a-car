package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.Car;
import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.tobetorentacar.services.dtos.responses.car.GetCarListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByColor(String color);
    List<Car> findByRentPriceLessThan(Double rentPrice);


   @Query("Select new com.example.tobetorentacar.services.dtos.responses.car." +
           "GetCarListResponse(c.modelYear,c.color,c.rentPrice," +
           "new com.example.tobetorentacar.services.dtos.responses.brand." +
           "GetBrandListResponse(b.name)) " +
           " From Car c INNER JOIN c.brand b")
   List<GetCarListResponse> getAll2();

   @Query("Select new com.example.tobetorentacar.services.dtos.responses.car." +
           "GetCarListResponse(c.modelYear,c.color,c.rentPrice," +
           "new com.example.tobetorentacar.services.dtos.responses.brand." +
           "GetBrandListResponse(b.name)) " +
           " From Car c INNER JOIN c.brand b Order By c.modelYear ASC ")
   List<GetCarListResponse> orderByModelYear();



}
