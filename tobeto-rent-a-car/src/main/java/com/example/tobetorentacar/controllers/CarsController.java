package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.entities.Car;
import com.example.tobetorentacar.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;
    public CarsController(CarRepository carRepository){
        this.carRepository=carRepository;

    }
    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id){
        return carRepository.findById(id).orElseThrow();

    }
    @PostMapping
    public void add(@RequestBody Car car){
         carRepository.save(car);
    }
    @PutMapping("{id}")
    public void update(@RequestBody Car uCar,@PathVariable int id){
        Car updateCar= carRepository.findById(id).orElseThrow();
        updateCar.setId(uCar.getId());
        updateCar.setColor(uCar.getColor());
        updateCar.setModelYear(uCar.getModelYear());
        updateCar.setRentPrice(uCar.getRentPrice());
        carRepository.save(updateCar);

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        carRepository.deleteById(id);
    }

}
