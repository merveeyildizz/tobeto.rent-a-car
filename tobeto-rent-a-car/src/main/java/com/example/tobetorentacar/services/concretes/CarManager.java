package com.example.tobetorentacar.services.concretes;

import com.example.tobetorentacar.entities.Car;
import com.example.tobetorentacar.repositories.CarRepository;
import com.example.tobetorentacar.services.abstracts.CarService;
import com.example.tobetorentacar.services.dtos.requests.car.AddCarRequest;
import com.example.tobetorentacar.services.dtos.requests.car.UpdateCarRequest;
import com.example.tobetorentacar.services.dtos.responses.car.GetCarListResponse;
import com.example.tobetorentacar.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<GetCarListResponse> getAll() {
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

    @Override
    public GetCarResponse getById(int id) {
        Car car= carRepository.findById(id).orElseThrow();
        GetCarResponse dto= new GetCarResponse();
        dto.setColor(car.getColor());
        dto.setModelYear(car.getModelYear());
        dto.setRentPrice(car.getRentPrice());
        return  dto;

    }

    @Override
    public void add(AddCarRequest request) {
        Car car=new Car();
        car.setModelYear(request.getModelYear());
        car.setRentPrice(request.getRentPrice());
        car.setColor(request.getColor());
        carRepository.save(car);

    }

    @Override
    public void update(UpdateCarRequest updateCarRequest, int id) {
        Car updateCar= carRepository.findById(id).orElseThrow();
        updateCar.setColor(updateCarRequest.getColor());
        updateCar.setModelYear(updateCarRequest.getModelYear());
        updateCar.setRentPrice(updateCarRequest.getRentPrice());
        carRepository.save(updateCar);

    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);

    }
}
