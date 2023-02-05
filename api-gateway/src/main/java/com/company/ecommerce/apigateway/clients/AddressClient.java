package com.company.ecommerce.apigateway.clients;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.ecommerce.apigateway.dtos.Address;
import com.company.ecommerce.apigateway.dtos.AddressDto;

@FeignClient("address-service")
public interface AddressClient {
    @GetMapping("/addresses")
    @CrossOrigin
    List<Address> read();

    @PostMapping("/addresses")
    @CrossOrigin
    Address create(@RequestBody Address address);


    @GetMapping("/orders/{orderId}/addresses")
    @CrossOrigin
    List<AddressDto> getAddressesForOrder(@PathVariable UUID orderId);

    @PutMapping("/orders/{orderId}/addresses")
    @CrossOrigin
    AddressDto addAddressToOrder(@RequestBody AddressDto item, @PathVariable UUID orderId);
}
