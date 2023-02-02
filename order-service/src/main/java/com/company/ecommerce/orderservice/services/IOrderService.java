package com.company.ecommerce.orderservice.services;

import com.company.ecommerce.orderservice.dtos.OrderDto;

import java.util.UUID;

public interface IOrderService {
    OrderDto create(OrderDto order);
    OrderDto getById(UUID id);
    void cancel(UUID id);
    void updateStatus(UUID id, int status);
}
