package com.company.ecommerce.orderservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.ecommerce.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {
    List<Order> findAll();
}
