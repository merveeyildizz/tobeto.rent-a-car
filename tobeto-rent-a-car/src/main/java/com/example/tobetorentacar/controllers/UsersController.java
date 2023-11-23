package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.dtos.requests.user.AddUserRequest;
import com.example.tobetorentacar.dtos.requests.user.UpdateUserRequest;
import com.example.tobetorentacar.dtos.responses.user.GetUserListResponse;
import com.example.tobetorentacar.dtos.responses.user.GetUserResponse;
import com.example.tobetorentacar.entities.User;
import com.example.tobetorentacar.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UserRepository userRepository;
    public UsersController(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @GetMapping
    public List<GetUserListResponse> getAll(){
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
    @GetMapping("{id}")
    public GetUserResponse getById(@PathVariable int id){

        User user= userRepository.findById(id).orElseThrow();
        GetUserResponse dto= new GetUserResponse();
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setAddress(user.getAddress());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddUserRequest request){
        User user=new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateUserRequest updateUserRequest)
    {
        User updateUser= userRepository.findById(id).orElseThrow();


        updateUser.setName(updateUserRequest.getName());
        updateUser.setSurname(updateUserRequest.getSurname());
        updateUser.setEmail(updateUserRequest.getEmail());
        updateUser.setAddress(updateUserRequest.getAddress());
        updateUser.setPhoneNumber(updateUserRequest.getPhoneNumber());
        userRepository.save(updateUser);
    }

}
