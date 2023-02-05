package com.company.ecommerce.apigateway.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.apigateway.clients.AddressClient;
import com.company.ecommerce.apigateway.dtos.Address;


@RestController
class AddressController {
    public final AddressClient addressClient;


    AddressController(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    @GetMapping("/addresses")
    @CrossOrigin
    public List<Address> read(){
        return addressClient.read();
    }

    @PostMapping("/addresses")
    @CrossOrigin
    public Address create(@RequestBody Address address){
        return addressClient.create(address);
    }
}
