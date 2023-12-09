package com.example.tobetorentacar.services.abstracts;

import com.example.tobetorentacar.services.dtos.requests.user.AddUserRequest;
import com.example.tobetorentacar.services.dtos.requests.user.UpdateUserRequest;
import com.example.tobetorentacar.services.dtos.responses.user.GetUserListResponse;
import com.example.tobetorentacar.services.dtos.responses.user.GetUserResponse;

import java.util.List;

public interface UserService {
    List<GetUserListResponse> getAll();
    GetUserResponse getById(int id);
    void add(AddUserRequest request);
    void delete(int id);
    void update(int id, UpdateUserRequest updateUserRequest);

    List<GetUserListResponse> findByName(String name);
    List<GetUserListResponse> findByEmail(String email);
    List<GetUserListResponse> getAll2();
    List<GetUserListResponse> findByEmailAddress(String email);
}
