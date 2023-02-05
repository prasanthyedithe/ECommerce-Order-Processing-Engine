package com.company.ecommerce.itemservice.controllers;

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

import com.company.ecommerce.itemservice.dtos.ItemDto;
import com.company.ecommerce.itemservice.entities.Item;
import com.company.ecommerce.itemservice.repositories.ItemRepository;
import com.company.ecommerce.itemservice.services.IItemService;

@RestController
@RequestMapping
public class ItemController {
    private final ItemRepository itemRepository;
    private final IItemService itemService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    public ItemController(ItemRepository itemRepository, IItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> getAll(){
    	LOGGER.info("All Items method");
        return itemRepository.findAll();
    }

    @PostMapping("/items")
    public Item create(@RequestBody Item item){
    	LOGGER.info("In Create Items method");
    	return itemRepository.save(item);
    }

    @PutMapping("orders/{orderId}/items")
    public ItemDto addItemToOrder(@RequestBody ItemDto item, @PathVariable UUID orderId){
    	LOGGER.info("In Add Item to Order method");
    	return itemService.addItemToOrder(item, orderId);
    }

    @GetMapping("orders/{orderId}/items")
    public List<ItemDto> getItemsForOrder(@PathVariable UUID orderId){
    	LOGGER.info("In Get Items for Order method");
        return itemService.getItemsForOrder(orderId);
    }
}
