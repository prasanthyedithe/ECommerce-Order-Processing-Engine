package com.company.ecommerce.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "status")
    public int status;

    @Column(name = "shipping_method")
    public int shippingMethod;

    @Column(name = "shipping_method_notes")
    public String shippingMethodNotes;

    @ManyToOne
    public Customer customer;

    @Column
    public double subtotal;

    @Column
    public double tax;

    @Column(name="shipping_charges")
    public double shippingCharges;

    @Column
    public double total;
    
    @Column(name="created_date")
    public Date createdDate;
    
    @Column(name="updated_date")
    public Date updatedDate;
}
