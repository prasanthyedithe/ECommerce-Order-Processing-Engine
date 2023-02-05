package com.company.ecommerce.apigateway.dtos;

import java.util.Date;
import java.util.UUID;

public class Address {
    public UUID id;
    public String line1;
    public String line2;
    public String city;
    public String state;
    public String zip;
    public Date createdDate;
    public Date updatedDate;
}

