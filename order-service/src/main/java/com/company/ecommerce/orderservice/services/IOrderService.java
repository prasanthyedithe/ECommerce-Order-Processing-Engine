package com.company.ecommerce.orderservice.services;

import java.util.UUID;

import com.company.ecommerce.orderservice.dtos.OrderDto;

public interface IOrderService {
    OrderDto create(OrderDto order);
    OrderDto getById(UUID id);
    void cancel(UUID id);
    void updateStatus(UUID id, int status);
}
