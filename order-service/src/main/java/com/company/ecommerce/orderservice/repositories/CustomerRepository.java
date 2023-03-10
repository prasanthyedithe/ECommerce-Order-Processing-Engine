package com.company.ecommerce.orderservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.company.ecommerce.entities.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, UUID> {
    List<Customer> findAll();
}
