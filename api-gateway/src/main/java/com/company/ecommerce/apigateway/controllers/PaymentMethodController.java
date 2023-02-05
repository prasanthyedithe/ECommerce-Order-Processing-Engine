package com.company.ecommerce.apigateway.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.apigateway.clients.PaymentMethodClient;
import com.company.ecommerce.apigateway.dtos.PaymentMethod;


@RestController
class PaymentMethodController {
    public final PaymentMethodClient paymentMethodClient;


    PaymentMethodController(PaymentMethodClient paymentMethodClient) {
        this.paymentMethodClient = paymentMethodClient;
    }

    @GetMapping("/payment-methods")
    @CrossOrigin
    public List<PaymentMethod> read(){
        return paymentMethodClient.read();
    }

    @PostMapping("/payment-methods")
    @CrossOrigin
    public PaymentMethod create(@RequestBody PaymentMethod paymentMethod){
        return paymentMethodClient.create(paymentMethod);
    }
}
