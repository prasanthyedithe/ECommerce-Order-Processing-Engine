package com.company.ecommerce.apigateway.clients;

import com.company.ecommerce.apigateway.dtos.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("customer-service")
public interface CustomerClient {
    @GetMapping("/customers")
    @CrossOrigin
    List<Customer> read();

    @PostMapping("/customers")
    @CrossOrigin
    Customer create(@RequestBody Customer customer);

}
