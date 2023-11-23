package com.example.tobetorentacar.controllers;


import com.example.tobetorentacar.dtos.requests.payment.AddPaymentRequest;
import com.example.tobetorentacar.dtos.requests.payment.UpdatePaymentRequest;
import com.example.tobetorentacar.dtos.responses.payment.GetPaymentListResponse;
import com.example.tobetorentacar.dtos.responses.payment.GetPaymentResponse;
import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.entities.Payment;
import com.example.tobetorentacar.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentRepository paymentRepository;
    public PaymentsController(PaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }

    @GetMapping
    public List<GetPaymentListResponse> getAll(){
        List<Payment> paymentList=paymentRepository.findAll();
        List<GetPaymentListResponse> paymentRespondList= new ArrayList<>();
        for(Payment payment: paymentList){
            GetPaymentListResponse dto= new GetPaymentListResponse();
            dto.setAmount(payment.getAmount());
            dto.setPaymentType(payment.getPaymentType());
            paymentRespondList.add(dto);
        }
        return paymentRespondList;
    }
    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id){
        Payment payment= paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse dto= new GetPaymentResponse();
        dto.setAmount(payment.getAmount());
        dto.setPaymentType(payment.getPaymentType());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest request){
        Payment payment=new Payment();
        payment.setAmount(request.getAmount());
        payment.setPaymentType(request.getPaymentType());
        paymentRepository.save(payment);
    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdatePaymentRequest updatePaymentRequest, @PathVariable int id){
        Payment updatePayment=paymentRepository.findById(id).orElseThrow();


        updatePayment.setPaymentType(updatePaymentRequest.getPaymentType());
        updatePayment.setAmount(updatePaymentRequest.getAmount());
        paymentRepository.save(updatePayment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentRepository.deleteById(id);
    }
}
