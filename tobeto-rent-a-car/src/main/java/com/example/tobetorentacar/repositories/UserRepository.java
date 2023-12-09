package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.User;
import com.example.tobetorentacar.services.dtos.responses.user.GetUserListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findByEmail(String email);

    @Query("Select new com.example.tobetorentacar.services.dtos.responses.user.GetUserListResponse(u.name,u.surname,u.email,u.phoneNumber,u.address)" +
            " from User u")
    List<GetUserListResponse> getAll2();

    @Query("Select new com.example.tobetorentacar.services.dtos.responses.user.GetUserListResponse(u.name,u.surname,u.email,u.phoneNumber,u.address) " +
            "from User u where u.email LIKE %:email% ")
    List<GetUserListResponse> findByEmailAddress(String email);




}
