package com.company.ecommerce.apigateway.clients;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.ecommerce.apigateway.dtos.OrderDto;

@FeignClient("order-service")
public interface OrderClient {
    @PostMapping("/orders")
    @CrossOrigin
    OrderDto create(@RequestBody OrderDto order);

    @GetMapping("/orders/{orderId}/cancel")
    @CrossOrigin
    void cancel(@PathVariable UUID orderId);

    @GetMapping("/orders/{orderId}")
    @CrossOrigin
    OrderDto get(@PathVariable UUID orderId);

    @PutMapping("/orders/{orderId}/status")
    @CrossOrigin
    void updateStatus(@PathVariable UUID orderId, @RequestBody int status);
}
