package com.company.ecommerce.apigateway.dtos;

import java.util.Date;
import java.util.UUID;

public class OrderStatusDto {
    public UUID orderId;
    public int status;
    public Date createdDate;
    public Date updatedDate;
}
