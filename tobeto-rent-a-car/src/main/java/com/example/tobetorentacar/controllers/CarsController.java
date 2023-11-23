package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.dtos.requests.car.AddCarRequest;
import com.example.tobetorentacar.dtos.requests.car.UpdateCarRequest;
import com.example.tobetorentacar.dtos.responses.car.GetCarListResponse;
import com.example.tobetorentacar.dtos.responses.car.GetCarResponse;
import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.entities.Car;
import com.example.tobetorentacar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;
    public CarsController(CarRepository carRepository){
        this.carRepository=carRepository;

    }
    @GetMapping
    public List<GetCarListResponse> getAll(){
        List<Car> carList=carRepository.findAll();
        List<GetCarListResponse> carListResponseList = new ArrayList<>();
        for(Car car: carList){
            GetCarListResponse dto=new GetCarListResponse();
            dto.setColor(car.getColor());
            dto.setRentPrice(car.getRentPrice());
            dto.setModelYear(car.getModelYear());
            carListResponseList.add(dto);
        }
        return carListResponseList;


    }

    @GetMapping("{id}")
    public GetCarResponse getById(@PathVariable int id){
        Car car= carRepository.findById(id).orElseThrow();
        GetCarResponse dto= new GetCarResponse();
        dto.setColor(car.getColor());
        dto.setModelYear(car.getModelYear());
        dto.setRentPrice(car.getRentPrice());
        return  dto;

    }
    @PostMapping
    public void add(@RequestBody AddCarRequest request){
        Car car=new Car();
        car.setModelYear(request.getModelYear());
        car.setRentPrice(request.getRentPrice());
        car.setColor(request.getColor());
        carRepository.save(car);
    }
    @PutMapping("{id}")
    public void update(@RequestBody UpdateCarRequest updateCarRequest, @PathVariable int id){
        Car updateCar= carRepository.findById(id).orElseThrow();
        updateCar.setColor(updateCarRequest.getColor());
        updateCar.setModelYear(updateCarRequest.getModelYear());
        updateCar.setRentPrice(updateCarRequest.getRentPrice());
        carRepository.save(updateCar);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);
    }

}
