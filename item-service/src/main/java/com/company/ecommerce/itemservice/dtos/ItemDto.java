package com.company.ecommerce.itemservice.dtos;

import java.util.Date;
import java.util.UUID;

public class ItemDto {
    public UUID id;
    public String name;
    public double price;
    public int quantity;
    public String productId;
    public String category;
    public String subCategory;
    public Date createdDate;
    public Date updatedDate;
}
