package com.company.ecommerce.paymentmethodservice.services;

import java.util.List;
import java.util.UUID;

import com.company.ecommerce.paymentmethodservice.dtos.PaymentMethodDto;

public interface IPaymentMethodService {
    PaymentMethodDto addPaymentMethodToOrder(PaymentMethodDto paymentMethod, UUID orderId);

    List<PaymentMethodDto> getPaymentMethodsForOrder(UUID orderId);
}
