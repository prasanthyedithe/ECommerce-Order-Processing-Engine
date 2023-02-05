package com.company.ecommerce.addressservice.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.company.ecommerce.addressservice.dtos.AddressDto;
import com.company.ecommerce.addressservice.entities.OrderAddress;
import com.company.ecommerce.addressservice.exceptions.NotFoundException;
import com.company.ecommerce.addressservice.repositories.AddressRepository;
import com.company.ecommerce.addressservice.repositories.OrderAddressRepository;

@Service
public class AddressService implements IAddressService{
    private final AddressRepository addressRepository;
    private final OrderAddressRepository orderAddressRepository;

    public AddressService(AddressRepository addressRepository, OrderAddressRepository orderAddressRepository) {
        this.addressRepository = addressRepository;
        this.orderAddressRepository = orderAddressRepository;
    }

    @Override
    public AddressDto addAddressToOrder(AddressDto x, UUID orderId) {
        if(x == null || orderId == null) return null;
        OrderAddress orderAddress = new OrderAddress();

        orderAddress.orderId = orderId;
        orderAddress.address = addressRepository.findById(x.id).orElseThrow(NotFoundException::new);
        orderAddress.type = x.type;

        return addressEntityToDto(orderAddressRepository.save(orderAddress));
    }

    @Override
    public List<AddressDto> getAddressForOrder(UUID orderId) {
        return orderAddressRepository.findAllByOrderId(orderId).parallelStream().map(this::addressEntityToDto).collect(Collectors.toList());
    }

    private AddressDto addressEntityToDto(OrderAddress addressInput){
        if(addressInput == null) return null;
        AddressDto output = new AddressDto();
        output.id = addressInput.address.id;
        output.city = addressInput.address.city;
        output.line1 = addressInput.address.line1;
        output.line2 = addressInput.address.line2;
        output.zip = addressInput.address.zip;
        output.state = addressInput.address.state;
        output.type = addressInput.type;
        output.createdDate = addressInput.createdDate;
        output.updatedDate = addressInput.updatedDate;
        return output;
    }
}
