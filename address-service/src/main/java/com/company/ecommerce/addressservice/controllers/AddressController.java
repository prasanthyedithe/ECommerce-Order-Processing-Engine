package com.company.ecommerce.addressservice.controllers;

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

import com.company.ecommerce.addressservice.dtos.AddressDto;
import com.company.ecommerce.addressservice.entities.Address;
import com.company.ecommerce.addressservice.repositories.AddressRepository;
import com.company.ecommerce.addressservice.services.IAddressService;

@RestController
@RequestMapping()
public class AddressController {
    private final AddressRepository addressRepository;
    private final IAddressService addressService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

    public AddressController(AddressRepository addressRepository, IAddressService addressService) {
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public List<Address> getAll(){
    	LOGGER.info("In getAll method");
        return addressRepository.findAll();
    }

    @PostMapping("/addresses")
    public Address create(@RequestBody Address address){
    	LOGGER.info("In Create Address method");
    	return addressRepository.save(address);
    }


    @PutMapping("orders/{orderId}/addresses")
    public AddressDto addAddressToOrder(@RequestBody AddressDto address, @PathVariable UUID orderId){
    	LOGGER.info("In Add Address to Order method");
    	return addressService.addAddressToOrder(address, orderId);
    }

    @GetMapping("orders/{orderId}/addresses")
    public List<AddressDto> getAddressesForOrder(@PathVariable UUID orderId){
    	LOGGER.info("In Get Address For Order method");
        return addressService.getAddressForOrder(orderId);
    }
}
