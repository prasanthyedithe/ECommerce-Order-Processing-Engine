package com.company.ecommerce.apigateway.controllers;

import com.company.ecommerce.apigateway.bulk.Sender;
import com.company.ecommerce.apigateway.dtos.OrderDto;
import com.company.ecommerce.apigateway.dtos.OrderStatusDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/orders-bulk")
public class OrderBulkController {

    private final Sender kafkaSender;

    public OrderBulkController(Sender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @PostMapping
    public void create(@RequestBody List<OrderDto> orders, HttpServletResponse response) {
        orders.forEach(this.kafkaSender::send);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    @PostMapping("/status")
    public void updateStatus(@RequestBody List<OrderStatusDto> orderStatusDtos, HttpServletResponse response){
        orderStatusDtos.forEach(this.kafkaSender::sendOrderStatus);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }
}
