package com.example.tobetorentacar.services.abstracts;

import com.example.tobetorentacar.services.dtos.requests.payment.AddPaymentRequest;
import com.example.tobetorentacar.services.dtos.requests.payment.UpdatePaymentRequest;
import com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentListResponse;
import com.example.tobetorentacar.services.dtos.responses.payment.GetPaymentResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PaymentService {
    List<GetPaymentListResponse> getAll();
    GetPaymentResponse getById(int id);
    void add(AddPaymentRequest request);
    void update(UpdatePaymentRequest updatePaymentRequest, int id);
    void delete(int id);

}
