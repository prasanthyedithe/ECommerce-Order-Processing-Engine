package com.company.ecommerce.paymentmethodservice.repositories;

import com.company.ecommerce.paymentmethodservice.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, UUID> {
}
