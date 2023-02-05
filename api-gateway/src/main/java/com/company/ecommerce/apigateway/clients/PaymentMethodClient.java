package com.company.ecommerce.apigateway.clients;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.ecommerce.apigateway.dtos.PaymentMethod;
import com.company.ecommerce.apigateway.dtos.PaymentMethodDto;

@FeignClient("payment-method-service")
public interface PaymentMethodClient {
    @GetMapping("/payment-methods")
    @CrossOrigin
    List<PaymentMethod> read();

    @PostMapping("/payment-methods")
    @CrossOrigin
    PaymentMethod create(@RequestBody PaymentMethod paymentMethod);


    @GetMapping("/orders/{orderId}/payment-methods")
    @CrossOrigin
    List<PaymentMethodDto> getPaymentMethodsForOrder(@PathVariable UUID orderId);

    @PutMapping("/orders/{orderId}/payment-methods")
    @CrossOrigin
    PaymentMethodDto addPaymentMethodToOrder(@RequestBody PaymentMethodDto item, @PathVariable UUID orderId);
}
