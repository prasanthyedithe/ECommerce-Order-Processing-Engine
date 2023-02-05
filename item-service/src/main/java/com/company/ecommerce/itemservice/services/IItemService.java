package com.company.ecommerce.itemservice.services;

import java.util.List;
import java.util.UUID;

import com.company.ecommerce.itemservice.dtos.ItemDto;

public interface IItemService {
    ItemDto addItemToOrder(ItemDto item, UUID orderId);

    List<ItemDto> getItemsForOrder(UUID orderId);
}
