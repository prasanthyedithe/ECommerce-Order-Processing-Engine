package com.company.ecommerce.itemservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ecommerce.itemservice.entities.Item;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
