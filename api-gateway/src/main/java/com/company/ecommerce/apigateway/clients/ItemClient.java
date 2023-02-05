package com.company.ecommerce.apigateway.clients;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.ecommerce.apigateway.dtos.Item;
import com.company.ecommerce.apigateway.dtos.ItemDto;

@FeignClient("item-service")
public interface ItemClient {
    @GetMapping("/items")
    @CrossOrigin
    List<Item> read();

    @PostMapping("/items")
    @CrossOrigin
    Item create(@RequestBody Item item);

    @GetMapping("/orders/{orderId}/items")
    @CrossOrigin
    List<ItemDto> getItemsForOrder(@PathVariable UUID orderId);

    @PutMapping("/orders/{orderId}/items")
    @CrossOrigin
    ItemDto addItemToOrder(@RequestBody ItemDto item, @PathVariable UUID orderId);
}
