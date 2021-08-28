package com.example.demo.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;

import com.example.demo.entity.Customer;

public interface CustomerService {
	
	Customer findById(Long id);
	Customer DeleteCustomer(Long id);
	Customer AddOrUpdateCustomer(Customer c);
	List<Customer> getAll();
	List<Customer> getAll(PageRequest p);
	
}
