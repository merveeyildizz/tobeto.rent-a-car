package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.services.abstracts.UserService;
import com.example.tobetorentacar.services.dtos.requests.user.AddUserRequest;
import com.example.tobetorentacar.services.dtos.requests.user.UpdateUserRequest;
import com.example.tobetorentacar.services.dtos.responses.user.GetUserListResponse;
import com.example.tobetorentacar.services.dtos.responses.user.GetUserResponse;
import com.example.tobetorentacar.entities.User;
import com.example.tobetorentacar.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;
    @GetMapping
    public List<GetUserListResponse> getAll(){
        return this.userService.getAll();

    }
    @GetMapping("{id}")
    public GetUserResponse getById(@PathVariable int id){
        return this.userService.getById(id);


    }

    @PostMapping
    public void add(@RequestBody AddUserRequest request){
        this.userService.add(request);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.userService.delete(id);

    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody UpdateUserRequest updateUserRequest)
    {
        this.userService.update(id,updateUserRequest);
    }

}
