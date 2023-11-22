package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
