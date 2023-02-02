package com.company.ecommerce.addressservice.repositories;

import com.company.ecommerce.addressservice.entities.OrderAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderAddressRepository extends CrudRepository<OrderAddress, UUID> {
    List<OrderAddress> findAll();
    List<OrderAddress> findAllByOrderId(UUID orderId);
}
