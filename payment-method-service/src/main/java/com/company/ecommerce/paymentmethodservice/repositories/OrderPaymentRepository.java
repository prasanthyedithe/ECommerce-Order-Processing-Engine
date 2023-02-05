package com.company.ecommerce.paymentmethodservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.company.ecommerce.paymentmethodservice.entities.OrderPayment;

public interface OrderPaymentRepository extends CrudRepository<OrderPayment, UUID> {
    List<OrderPayment> findAll();
    List<OrderPayment> findAllByOrderId(UUID orderId);
}
