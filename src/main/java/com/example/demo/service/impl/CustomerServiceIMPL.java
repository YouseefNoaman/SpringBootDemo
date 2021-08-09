package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.util.Util;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceIMPL implements CustomerService {

	private final CustomerRepository customerRepository;
	Util util = new Util();

	@Autowired
	public CustomerServiceIMPL(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer findById(Long id) {
		if (id != null)
			return customerRepository.getById(id);
		return null;
	}

	@Override
	public Customer DeleteCustomer(Long id) {
		Customer c = new Customer();
		if (id != null)
			c = customerRepository.getById(id);
		else {
			if (util.checkCustomerObj(c)) {
				customerRepository.delete(c);
				return c;
			}
		}
		return null;
	}

	@Override
	public Customer AddOrUpdateCustomer(Customer c) {
		if (util.checkCustomerObj(c))
			return customerRepository.save(c);
		return null;
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}
}
