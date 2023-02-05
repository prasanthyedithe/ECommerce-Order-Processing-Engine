package com.company.ecommerce.addressservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ecommerce.addressservice.entities.Address;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
