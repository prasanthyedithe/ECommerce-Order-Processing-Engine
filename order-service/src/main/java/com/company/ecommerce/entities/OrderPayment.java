package com.company.ecommerce.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_payments")
public class OrderPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @OneToOne
    @JoinColumn(name = "order_id")
    public Order order;

    @OneToOne
    @JoinColumn(name = "method_id")
    public PaymentMethod paymentMethod;

    @Column
    public double amount;

    @Column
    public Date date;

    @Column(name="confirmation_number")
    public String confirmationNumber;
    
    @Column(name="created_date")
    public Date createdDate;
    
    @Column(name="updated_date")
    public Date updatedDate;
}
