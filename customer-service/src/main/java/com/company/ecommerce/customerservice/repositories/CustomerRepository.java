package com.company.ecommerce.customerservice.repositories;

import com.company.ecommerce.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
