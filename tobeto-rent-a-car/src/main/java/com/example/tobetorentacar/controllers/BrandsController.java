package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;
    public BrandsController(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }
    @GetMapping
    public List<Brand> getAll(){

        return brandRepository.findAll();
    }

    @GetMapping("{id}")
    public Brand getById(@PathVariable int id){

        return brandRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Brand brand){

        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

        brandRepository.deleteById(id);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody Brand uBrand) {
        Brand updateBrand = brandRepository.findById(id).orElseThrow();

        updateBrand.setName(uBrand.getName());
        updateBrand.setId(uBrand.getId());
        brandRepository.save(updateBrand);

    }


}
