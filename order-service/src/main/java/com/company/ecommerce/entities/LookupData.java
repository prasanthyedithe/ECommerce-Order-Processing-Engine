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
@Table(name="lookup_data")
public class LookupData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
	
	@Column
    public String type;
	
    @Column
    public String key;
	
    @Column
    public String value;
	  
    @Column(name="created_date")
    public Date createdDate;
    
    @Column(name="updated_date")
    public Date updatedDate;



}
