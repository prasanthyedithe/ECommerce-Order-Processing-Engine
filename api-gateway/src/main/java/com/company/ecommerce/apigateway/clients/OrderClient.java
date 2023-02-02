package com.company.ecommerce.apigateway.clients;

import com.company.ecommerce.apigateway.dtos.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
