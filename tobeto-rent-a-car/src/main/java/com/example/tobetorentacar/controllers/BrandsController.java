package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.services.abstracts.BrandService;
import com.example.tobetorentacar.services.dtos.requests.brand.AddBrandRequest;
import com.example.tobetorentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandResponse;
import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    private final BrandService brandService;
    @GetMapping
    public List<GetBrandListResponse> getAll(){
        return this.brandService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandResponse getById(@PathVariable int id){
        return this.brandService.getById(id);

    }

    @PostMapping
    public void add(@RequestBody AddBrandRequest request){
        this.brandService.add(request);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);

    }
    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest,id);
    }


}
