package com.example.tobetorentacar.controllers;


import com.example.tobetorentacar.services.abstracts.PaymentService;
import com.example.tobetorentacar.services.dtos.requests.payment.AddPaymentRequest;
import com.example.tobetorentacar.services.dtos.requests.payment.UpdatePaymentRequest;
import com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentListResponse;
import com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentResponse;
import com.example.tobetorentacar.entities.Payment;
import com.example.tobetorentacar.repositories.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/payments")
@AllArgsConstructor
public class PaymentsController {
    private final PaymentService paymentService;


    @GetMapping
    public List<GetPaymentListResponse> getAll(){
        return this.paymentService.getAll();

    }
    @GetMapping("{id}")
    public GetPaymentResponse getById(@PathVariable int id){
        return this.paymentService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddPaymentRequest request){
        this.paymentService.add(request);

    }

    @PutMapping("{id}")
    public void update(@RequestBody UpdatePaymentRequest updatePaymentRequest, @PathVariable int id){
        this.paymentService.update(updatePaymentRequest,id);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.paymentService.delete(id);

    }
}
