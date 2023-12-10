package com.example.tobetorentacar.services.concretes;

import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.repositories.BrandRepository;
import com.example.tobetorentacar.services.abstracts.BrandService;
import com.example.tobetorentacar.services.dtos.requests.brand.AddBrandRequest;
import com.example.tobetorentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;


    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brandList = brandRepository.findAll();
        List<GetBrandListResponse> brandRespondList = new ArrayList<>();
        for(Brand brand: brandList){
            GetBrandListResponse dto = new GetBrandListResponse();
            dto.setName(brand.getName());
            brandRespondList.add(dto);
        }
        return brandRespondList;
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand= brandRepository.findById(id).orElseThrow();
        GetBrandResponse dto= new GetBrandResponse();
        dto.setName(brand.getName());
        return dto;
    }

    @Override
    public void add(AddBrandRequest request) {
        if(brandRepository.existsByName(request.getName().trim())){
            throw new RuntimeException("Aynı isimle iki marka eklenemez");
        }
        Brand brand=new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest, int id) {
        Brand updateBrand = brandRepository.findById(id).orElseThrow();

        updateBrand.setName(updateBrandRequest.getName());
        brandRepository.save(updateBrand);

    }

    @Override
    public List<GetBrandListResponse> getByNameOrId(String name, int id) {
        List<Brand> brands = brandRepository.findByNameLikeOrIdEquals("%"+name+"%", id);
        List<GetBrandListResponse> response = new ArrayList<>();

        for (Brand brand: brands) {
            response.add(new GetBrandListResponse(brand.getName()));
        }
        return response;
    }

    @Override
    public List<GetBrandListResponse> getByNameStartingWith(String name) {
        List<Brand> brands=brandRepository.findByNameStartingWith(name);
        List<GetBrandListResponse> response=new ArrayList<>();
        for(Brand brand:brands){
            response.add(new GetBrandListResponse(brand.getName()));
        }
        return response;
    }

    @Override
    public List<GetBrandListResponse> search(String name) {

        return brandRepository.search(name);
    }

    @Override
    public List<GetBrandListResponse> order() {
        return brandRepository.order();
    }


}
