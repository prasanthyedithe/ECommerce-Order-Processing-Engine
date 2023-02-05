package com.company.ecommerce.paymentmethodservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ecommerce.paymentmethodservice.entities.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, UUID> {
}
