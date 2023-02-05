package com.company.ecommerce.itemservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.company.ecommerce.itemservice.entities.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {
    List<OrderItem> findAll();
    List<OrderItem> findAllByOrderId(UUID orderId);
}
