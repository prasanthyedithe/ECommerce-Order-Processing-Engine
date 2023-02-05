package com.company.ecommerce.apigateway.dtos;

import java.util.Date;
import java.util.UUID;

public class Item {
    public UUID id;
    public String name;
    public double price;
    public String productId;
    public String category;
    public String subCategory;
    public Date createdDate;
    public Date updatedDate;
}
