package com.company.ecommerce.orderservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.company.ecommerce.entities.LookupData;

public interface LookupDataRepository  extends CrudRepository<LookupData, UUID> {
	 List<LookupData> findAll();

}
