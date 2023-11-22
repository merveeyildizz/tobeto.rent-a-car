package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
