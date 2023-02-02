package com.company.ecommerce.orderservice.controllers;

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

import com.company.ecommerce.orderservice.dtos.OrderDto;
import com.company.ecommerce.orderservice.services.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final IOrderService orderService;
    private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class.getName());

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public OrderDto findById(@PathVariable UUID orderId) {
        LOGGER.info("Received request to fetch order by order id {}", orderId);
        return orderService.getById(orderId);
    }

    @PostMapping
    public OrderDto create(@RequestBody OrderDto order) {
        LOGGER.info("Received request to create order.");
        return orderService.create(order);
    }

    @GetMapping("/{id}/cancel")
    public void cancel(@PathVariable UUID id){
        LOGGER.info("Received request to cancel order");
        orderService.cancel(id);
    }

    @PutMapping("/{id}/status")
    public void putStatus(@PathVariable UUID id, @RequestBody int status){
        LOGGER.info("Received request to update status id {} status {} ", id, status);
        orderService.updateStatus(id, status);
    }
}
