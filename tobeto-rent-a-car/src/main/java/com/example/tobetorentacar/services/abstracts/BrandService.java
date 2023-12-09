package com.example.tobetorentacar.services.abstracts;

import com.example.tobetorentacar.services.dtos.requests.brand.AddBrandRequest;
import com.example.tobetorentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest request);
    void delete(int id);
    void update(UpdateBrandRequest updateBrandRequest,int id);
    List<GetBrandListResponse> getByNameOrId(String name,int id);
    List<GetBrandListResponse> getByNameStartingWith(String name);
    List<GetBrandListResponse> search(String name);
    List<GetBrandListResponse> order();






}
