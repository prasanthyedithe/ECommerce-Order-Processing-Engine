package com.company.ecommerce.apigateway.controllers;

import com.company.ecommerce.apigateway.clients.CustomerClient;
import com.company.ecommerce.apigateway.dtos.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class CustomerController {
    public final CustomerClient customerClient;


    CustomerController(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    @GetMapping("/customers")
    @CrossOrigin
    public List<Customer> read(){
        return customerClient.read();
    }

    @PostMapping("/customers")
    @CrossOrigin
    public Customer create(@RequestBody Customer customer){
        return customerClient.create(customer);
    }

}
