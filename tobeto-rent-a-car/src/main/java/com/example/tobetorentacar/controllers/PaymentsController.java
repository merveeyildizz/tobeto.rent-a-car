package com.example.tobetorentacar.controllers;


import com.example.tobetorentacar.entities.Brand;
import com.example.tobetorentacar.entities.Payment;
import com.example.tobetorentacar.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentRepository paymentRepository;
    public PaymentsController(PaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }

    @GetMapping
    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }
    @GetMapping("{id}")
    public Payment getById(@PathVariable int id){
        return paymentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentRepository.save(payment);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Payment uPayment,@PathVariable int id){
        Payment updatePayment=paymentRepository.findById(id).orElseThrow();

        updatePayment.setId(uPayment.getId());
        updatePayment.setPaymentType(uPayment.getPaymentType());
        updatePayment.setAmount(uPayment.getAmount());
        paymentRepository.save(updatePayment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentRepository.deleteById(id);
    }
}
