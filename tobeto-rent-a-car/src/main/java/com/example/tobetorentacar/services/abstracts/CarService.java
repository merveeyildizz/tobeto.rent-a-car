package com.example.tobetorentacar.services.abstracts;

import com.example.tobetorentacar.entities.Car;
import com.example.tobetorentacar.services.dtos.requests.car.AddCarRequest;
import com.example.tobetorentacar.services.dtos.requests.car.UpdateCarRequest;
import com.example.tobetorentacar.services.dtos.responses.car.GetCarListResponse;
import com.example.tobetorentacar.services.dtos.responses.car.GetCarResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAll();
    GetCarResponse getById(int id);
    void add(AddCarRequest request);
    void update(UpdateCarRequest updateCarRequest,int id);
    void delete(int id);

    List<GetCarListResponse> getByColor(String color);
    List<GetCarListResponse> getByRentPriceLessThan(Double rentPrice);
    List<GetCarListResponse> getAll2();
    List<GetCarListResponse> orderByModelYear();








}
