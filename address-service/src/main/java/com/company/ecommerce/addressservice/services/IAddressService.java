package com.company.ecommerce.addressservice.services;

import java.util.List;
import java.util.UUID;

import com.company.ecommerce.addressservice.dtos.AddressDto;

public interface IAddressService {
    AddressDto addAddressToOrder(AddressDto address, UUID orderId);

    List<AddressDto> getAddressForOrder(UUID orderId);
}
