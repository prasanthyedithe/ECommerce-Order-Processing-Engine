package com.company.ecommerce.customerservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ecommerce.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
