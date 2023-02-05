package com.company.ecommerce.paymentmethodservice.controllers;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.paymentmethodservice.dtos.PaymentMethodDto;
import com.company.ecommerce.paymentmethodservice.entities.PaymentMethod;
import com.company.ecommerce.paymentmethodservice.repositories.PaymentMethodRepository;
import com.company.ecommerce.paymentmethodservice.services.PaymentMethodService;

@RestController
@RequestMapping
public class PaymentMethodController {
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMethodService paymentMethodService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodController.class);

    public PaymentMethodController(PaymentMethodRepository paymentMethodRepository, PaymentMethodService paymentMethodService) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("/payment-methods")
    public List<PaymentMethod> getAll(){
    	LOGGER.info("All Payment Method getAll method");
        return paymentMethodRepository.findAll();
    }

    @PostMapping("/payment-methods")
    public PaymentMethod create(@RequestBody PaymentMethod paymentMethod){
    	LOGGER.info("In Create method");
        return paymentMethodRepository.save(paymentMethod);
    }

    @PutMapping("orders/{orderId}/payment-methods")
    public PaymentMethodDto addPaymentMethodToOrder(@RequestBody PaymentMethodDto paymentMethod, @PathVariable UUID orderId){
    	LOGGER.info("In Add Payment Methof to Order method");
    	return paymentMethodService.addPaymentMethodToOrder(paymentMethod, orderId);
    }

    @GetMapping("orders/{orderId}/payment-methods")
    public List<PaymentMethodDto> getItemsForOrder(@PathVariable UUID orderId){
    	LOGGER.info("In Get Items for Order");
        return paymentMethodService.getPaymentMethodsForOrder(orderId);
    }
}
