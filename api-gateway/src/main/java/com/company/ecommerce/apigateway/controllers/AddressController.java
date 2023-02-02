package com.company.ecommerce.apigateway.controllers;

import com.company.ecommerce.apigateway.clients.AddressClient;
import com.company.ecommerce.apigateway.dtos.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
