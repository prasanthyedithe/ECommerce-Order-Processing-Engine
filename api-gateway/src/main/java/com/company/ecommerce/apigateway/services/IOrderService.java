package com.company.ecommerce.apigateway.services;

import java.util.UUID;

import com.company.ecommerce.apigateway.dtos.OrderDto;

public interface IOrderService {
    OrderDto create(OrderDto order);
    OrderDto getOrderById(UUID id);
    void cancel(UUID id);
    void updateStatus(UUID orderId, int status);
}
