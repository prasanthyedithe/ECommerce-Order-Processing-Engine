package com.company.ecommerce.addressservice.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column
    public String line1;

    @Column
    public String line2;

    @Column
    public String city;

    @Column
    public String state;

    @Column
    public String zip;
    
    @Column(name="created_date")
    public Date createdDate;
    
    @Column(name="updated_date")
    public Date updatedDate;
}
