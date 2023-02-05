package com.company.ecommerce.orderservice.services;

import java.util.UUID;

import com.company.ecommerce.orderservice.dtos.LookupDataDto;

public interface ILookupDataService {
	LookupDataDto getById(UUID id);

	LookupDataDto create(LookupDataDto lookupDataDto);

}
