package com.company.ecommerce.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column
    public String name;

    @Column
    public double price;
    
    @Column(name="product_id")
    public String productId;
    
    @Column(name="category")
    public String category;
    
    @Column(name="sub_category")
    public String subCategory;
    
    @Column(name="created_date")
    public Date createdDate;
    
    @Column(name="updated_date")
    public Date updatedDate;
}
