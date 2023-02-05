package com.company.ecommerce.customerservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.customerservice.entities.Customer;
import com.company.ecommerce.customerservice.repositories.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll(){
    	LOGGER.info("In Find All method");
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
    	LOGGER.info("In Create method");
    	return customerRepository.save(customer);
    }
}
