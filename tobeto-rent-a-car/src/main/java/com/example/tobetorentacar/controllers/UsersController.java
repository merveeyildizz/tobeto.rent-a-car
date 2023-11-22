package com.example.tobetorentacar.controllers;

import com.example.tobetorentacar.entities.User;
import com.example.tobetorentacar.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UsersController {
    private final UserRepository userRepository;
    public UsersController(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }
    @GetMapping("{id}")
    public User getById(@PathVariable int id){
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id,@RequestBody User upUser)
    {
        User updateUser= userRepository.findById(id).orElseThrow();

        updateUser.setId(upUser.getId());
        updateUser.setName(upUser.getName());
        updateUser.setSurname(upUser.getSurname());
        updateUser.setEmail(upUser.getEmail());
        updateUser.setAddress(upUser.getAddress());
        updateUser.setPhoneNumber(upUser.getPhoneNumber());
        userRepository.save(updateUser);
    }

}
