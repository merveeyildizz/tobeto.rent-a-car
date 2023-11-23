package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.dtos.requests.brand.AddBrandRequest;
import com.example.tobetorentacar.dtos.requests.brand.UpdateBrandRequest;
import com.example.tobetorentacar.dtos.responses.brand.GetBrandListResponse;
import com.example.tobetorentacar.dtos.responses.brand.GetBrandResponse;
import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.repositories.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandRepository brandRepository;
    public BrandsController(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }
    @GetMapping
    public List<GetBrandListResponse> getAll(){
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> brandRespondList = new ArrayList<>();
        for(Brand brand: brandList){
            GetBrandListResponse dto = new GetBrandListResponse();
            dto.setName(brand.getName());
            brandRespondList.add(dto);
        }
        return brandRespondList;


    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){

        Brand brand= brandRepository.findById(id).orElseThrow();
        GetBrandResponse dto= new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        Brand brand=new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
       brandRepository.delete(brandToDelete);

        //brandRepository.deleteById(id);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateBrandRequest updateBrandRequest) {
        Brand updateBrand = brandRepository.findById(id).orElseThrow();

        updateBrand.setName(updateBrandRequest.getName());
        brandRepository.save(updateBrand);

    }


}
