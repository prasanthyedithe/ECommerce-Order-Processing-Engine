package com.company.ecommerce.apigateway.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.ecommerce.apigateway.dtos.Customer;

@FeignClient("customer-service")
public interface CustomerClient {
    @GetMapping("/customers")
    @CrossOrigin
    List<Customer> read();

    @PostMapping("/customers")
    @CrossOrigin
    Customer create(@RequestBody Customer customer);

}
