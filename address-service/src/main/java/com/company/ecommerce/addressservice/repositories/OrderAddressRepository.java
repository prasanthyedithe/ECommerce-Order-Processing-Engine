package com.company.ecommerce.addressservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.company.ecommerce.addressservice.entities.OrderAddress;

public interface OrderAddressRepository extends CrudRepository<OrderAddress, UUID> {
    List<OrderAddress> findAll();
    List<OrderAddress> findAllByOrderId(UUID orderId);
}
