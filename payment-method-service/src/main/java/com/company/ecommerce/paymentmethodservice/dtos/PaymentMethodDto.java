package com.company.ecommerce.paymentmethodservice.dtos;

import java.util.Date;
import java.util.UUID;

public class PaymentMethodDto {
    public UUID id;
    public int type;
    public String details;
    public double amount;
    public Date date;
    public String confirmationNumber;
    public Date createdDate;
    public Date updatedDate;
}
