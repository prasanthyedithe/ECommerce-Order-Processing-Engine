package com.company.ecommerce.itemservice.repositories;

import com.company.ecommerce.itemservice.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {
    List<OrderItem> findAll();
    List<OrderItem> findAllByOrderId(UUID orderId);
}
