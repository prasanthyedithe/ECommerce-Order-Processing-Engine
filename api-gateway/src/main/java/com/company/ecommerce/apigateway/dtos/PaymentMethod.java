package com.company.ecommerce.apigateway.dtos;

import java.util.Date;
import java.util.UUID;

public class PaymentMethod {
    public UUID id;
    public int type;
    public String details;
    public Date createdDate;
    public Date updatedDate;
}

