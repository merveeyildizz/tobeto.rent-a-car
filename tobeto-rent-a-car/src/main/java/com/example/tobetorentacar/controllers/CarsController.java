package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.services.abstracts.CarService;
import com.example.tobetorentacar.services.dtos.requests.car.AddCarRequest;
import com.example.tobetorentacar.services.dtos.requests.car.UpdateCarRequest;
import com.example.tobetorentacar.services.dtos.responses.car.GetCarListResponse;
import com.example.tobetorentacar.services.dtos.responses.car.GetCarResponse;
import com.example.tobetorentacar.entities.Car;
import com.example.tobetorentacar.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {
    private final CarService carService;

    @GetMapping
    public List<GetCarListResponse> getAll(){
        return this.carService.getAll();
    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        return this.carService.getById(id);

    }
    @PostMapping
    public void add(@RequestBody AddCarRequest request){
        this.carService.add(request);

    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateCarRequest updateCarRequest, @PathVariable int id){
        this.carService.update(updateCarRequest,id);


    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.carService.delete(id);

    }

}
