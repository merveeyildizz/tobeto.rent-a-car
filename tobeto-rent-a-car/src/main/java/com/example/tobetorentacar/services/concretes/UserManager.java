package com.example.tobetorentacar.services.concretes;

import com.example.tobetorentacar.entities.User;
import com.example.tobetorentacar.repositories.UserRepository;
import com.example.tobetorentacar.services.abstracts.UserService;
import com.example.tobetorentacar.services.dtos.requests.user.AddUserRequest;
import com.example.tobetorentacar.services.dtos.requests.user.UpdateUserRequest;
import com.example.tobetorentacar.services.dtos.responses.user.GetUserListResponse;
import com.example.tobetorentacar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<GetUserListResponse> getAll() {

        List<User> userList= userRepository.findAll();
        List<GetUserListResponse> userListResponses=new ArrayList<>();
        for(User user: userList){
            GetUserListResponse dto= new GetUserListResponse();
            dto.setAddress(user.getAddress());
            dto.setSurname(user.getSurname());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhoneNumber(user.getPhoneNumber());
            userListResponses.add(dto);

        }
        return userListResponses;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user= userRepository.findById(id).orElseThrow();
        GetUserResponse dto= new GetUserResponse();
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setAddress(user.getAddress());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }

    @Override
    public void add(AddUserRequest request) {
        User user=new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        userRepository.save(user);

    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void update(int id, UpdateUserRequest updateUserRequest) {
        User updateUser= userRepository.findById(id).orElseThrow();


        updateUser.setName(updateUserRequest.getName());
        updateUser.setSurname(updateUserRequest.getSurname());
        updateUser.setEmail(updateUserRequest.getEmail());
        updateUser.setAddress(updateUserRequest.getAddress());
        updateUser.setPhoneNumber(updateUserRequest.getPhoneNumber());
        userRepository.save(updateUser);

    }
}
