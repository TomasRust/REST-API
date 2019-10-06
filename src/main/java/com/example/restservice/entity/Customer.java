package com.example.restservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Aanmaken van table op basis van class
@Table(name = "customers")
public class Customer {
	
	
	@Id //Primary Key
	private long customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
    	this.customerId = customerId;
    }
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "email_address", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmailId(String email) {
        this.email = email;
    }
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	
	
}