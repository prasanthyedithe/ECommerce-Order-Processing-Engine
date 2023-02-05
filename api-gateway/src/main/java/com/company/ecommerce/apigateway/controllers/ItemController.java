package com.company.ecommerce.apigateway.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.ecommerce.apigateway.clients.ItemClient;
import com.company.ecommerce.apigateway.dtos.Item;


@RestController
class ItemController {
    public final ItemClient itemClient;


    ItemController(ItemClient itemClient) {
        this.itemClient = itemClient;
    }

    @GetMapping("/items")
    @CrossOrigin
    public List<Item> read(){
        return itemClient.read();
    }

    @PostMapping("/items")
    @CrossOrigin
    public Item create(@RequestBody Item item){
        return itemClient.create(item);
    }

}
