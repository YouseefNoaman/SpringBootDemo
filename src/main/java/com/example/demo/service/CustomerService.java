package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {
	
	Customer findById(Long id);
	Customer DeleteCustomer(Long id);
	Customer AddOrUpdateCustomer(Customer c);
	List<Customer> getAll();
	
}
