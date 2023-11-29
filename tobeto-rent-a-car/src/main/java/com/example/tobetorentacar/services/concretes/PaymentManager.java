package com.example.tobetorentacar.services.concretes;

import com.example.tobetorentacar.entities.Payment;
import com.example.tobetorentacar.repositories.PaymentRepository;
import com.example.tobetorentacar.services.abstracts.PaymentService;
import com.example.tobetorentacar.services.dtos.requests.payment.AddPaymentRequest;
import com.example.tobetorentacar.services.dtos.requests.payment.UpdatePaymentRequest;
import com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentListResponse;
import com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service

public class PaymentManager implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public List<GetPaymentListResponse> getAll() {
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

    @Override
    public GetPaymentResponse getById(int id) {
        Payment payment= paymentRepository.findById(id).orElseThrow();
        GetPaymentResponse dto= new GetPaymentResponse();
        dto.setAmount(payment.getAmount());
        dto.setPaymentType(payment.getPaymentType());
        return dto;
    }

    @Override
    public void add(AddPaymentRequest request) {
        Payment payment=new Payment();
        payment.setAmount(request.getAmount());
        payment.setPaymentType(request.getPaymentType());
        paymentRepository.save(payment);

    }

    @Override
    public void update(UpdatePaymentRequest updatePaymentRequest, int id) {
        Payment updatePayment=paymentRepository.findById(id).orElseThrow();

        updatePayment.setPaymentType(updatePaymentRequest.getPaymentType());
        updatePayment.setAmount(updatePaymentRequest.getAmount());
        paymentRepository.save(updatePayment);

    }

    @Override
    public void delete(int id) {
        paymentRepository.deleteById(id);

    }
}
