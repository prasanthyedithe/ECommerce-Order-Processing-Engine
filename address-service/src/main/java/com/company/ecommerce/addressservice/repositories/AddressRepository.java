package com.company.ecommerce.addressservice.repositories;

import com.company.ecommerce.addressservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
