package com.company.ecommerce.apigateway.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.apigateway.clients.CustomerClient;
import com.company.ecommerce.apigateway.dtos.Customer;


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
