package com.example.tobetorentacar.repositories;

import com.example.tobetorentacar.entities.Payment;
import com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findByAmountLessThanEqual(int amount);
    List<Payment> findByAmountGreaterThanEqual(int amount);

    @Query("Select new com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentListResponse(p.amount,p.paymentType)" +
            " from Payment p Where p.paymentType LIKE %:paymentType%")
    List<GetPaymentListResponse> searchPaymentType(String paymentType);

    @Query("Select new com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentListResponse(p.amount,p.paymentType) from Payment p ")
    List<GetPaymentListResponse> getAll2();

}

