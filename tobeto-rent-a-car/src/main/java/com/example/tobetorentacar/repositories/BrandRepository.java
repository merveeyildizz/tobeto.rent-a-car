package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.services.dtos.responses.brand.GetBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository <Brand,Integer> {

    List<Brand> findByNameLikeOrIdEquals(String name, int id);
    List<Brand> findByNameStartingWith(String name);

    @Query("SELECT new com.example.tobetorentacar.services.dtos.responses.brand.GetBrandListResponse(b.name)" +
            " FROM Brand b where b.name LIKE %:name% ")
    List<GetBrandListResponse> search(String name);

    @Query("Select new com.example.tobetorentacar.services.dtos.responses.brand." +
            "GetBrandListResponse(b.name)" +
            " From Brand b Order By b.name ASC ")
    List<GetBrandListResponse> order();



















}
