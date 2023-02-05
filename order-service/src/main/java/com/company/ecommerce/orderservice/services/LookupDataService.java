package com.company.ecommerce.orderservice.services;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.ecommerce.entities.LookupData;
import com.company.ecommerce.orderservice.dtos.LookupDataDto;
import com.company.ecommerce.orderservice.exceptions.BadRequestException;
import com.company.ecommerce.orderservice.exceptions.NotFoundException;
import com.company.ecommerce.orderservice.repositories.LookupDataRepository;

public class LookupDataService implements ILookupDataService {

	private final Logger logger = LoggerFactory.getLogger(OrderService.class.getName());
	private final LookupDataRepository lookupDataRepository;

	public LookupDataService(LookupDataRepository lookupDataRepository) {
		this.lookupDataRepository = lookupDataRepository;
	}

	@Override
	public LookupDataDto getById(UUID id) {
		return lookupDataEntityToDto(lookupDataRepository.findById(id).orElseThrow(NotFoundException::new));
	}

	@Override
	public LookupDataDto create(LookupDataDto lookupDataDto) {
		if (lookupDataDto.id != null)
			throw new BadRequestException();
		return lookupDataEntityToDto(lookupDataRepository.save(lookupDataEntityToDto(lookupDataDto)));
	}
	
	private LookupData lookupDataEntityToDto(LookupDataDto lookupDataDto) {
		if (lookupDataDto == null)
			return null;

		logger.info("Converting lookupdata entity to dto");

		LookupData lookupData = new LookupData();
		lookupData.id = lookupDataDto.id;
		lookupData.type = lookupDataDto.type;
		lookupData.key = lookupDataDto.key;
		lookupData.value = lookupDataDto.value;
		lookupData.createdDate = lookupDataDto.createdDate;
		lookupData.updatedDate = lookupDataDto.updatedDate;

		return lookupData;
	}

	private LookupDataDto lookupDataEntityToDto(LookupData lookupData) {
		if (lookupData == null)
			return null;

		logger.info("Converting lookupdata entity to dto");

		LookupDataDto lookupDataDto = new LookupDataDto();
		lookupDataDto.id = lookupData.id;
		lookupDataDto.type = lookupData.type;
		lookupDataDto.key = lookupData.key;
		lookupDataDto.value = lookupData.value;
		lookupDataDto.createdDate = lookupData.createdDate;
		lookupDataDto.updatedDate = lookupData.updatedDate;

		return lookupDataDto;
	}

}
