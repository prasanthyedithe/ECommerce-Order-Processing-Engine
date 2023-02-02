package com.company.ecommerce.apigateway.services;

import com.company.ecommerce.apigateway.dtos.OrderDto;

import java.util.UUID;

public interface IOrderService {
    OrderDto create(OrderDto order);
    OrderDto getOrderById(UUID id);
    void cancel(UUID id);
    void updateStatus(UUID orderId, int status);
}
