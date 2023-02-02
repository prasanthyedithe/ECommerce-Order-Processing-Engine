package com.company.ecommerce.paymentmethodservice.services;

import com.company.ecommerce.paymentmethodservice.dtos.PaymentMethodDto;

import java.util.List;
import java.util.UUID;

public interface IPaymentMethodService {
    PaymentMethodDto addPaymentMethodToOrder(PaymentMethodDto paymentMethod, UUID orderId);

    List<PaymentMethodDto> getPaymentMethodsForOrder(UUID orderId);
}
