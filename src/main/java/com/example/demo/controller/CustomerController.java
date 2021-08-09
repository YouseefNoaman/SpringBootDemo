package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.impl.CustomerServiceIMPL;

@RestController
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	private CustomerServiceIMPL customerService;

	@Autowired
	CustomerController(CustomerServiceIMPL customerService) {
		Objects.requireNonNull(customerService);
		this.customerService = customerService;
	}

	@GetMapping("/info")
	public String info() {
		log.info("Logs are working");
		log.debug("debug " + log.isDebugEnabled());
		log.error("error " + log.isInfoEnabled());
		return "THIS IS WORKING";
	}

	@GetMapping("/all")
	public List<Customer> getALL() {
		return customerService.getAll();
	}

	@GetMapping("/{id}")
	public Customer getById(@PathVariable("id") Long id) {
		return customerService.findById(id);
	}

	@PostMapping("/")
	public Customer addCustomer(@RequestBody Customer c) {
		return customerService.AddOrUpdateCustomer(c);
	}

	@DeleteMapping("/{id}")
	public Customer deleteCustomer(@PathVariable("id") Long id) {
		return customerService.DeleteCustomer(id);
	}

	@PutMapping("/")
	public Customer editCustomer(@RequestBody Customer c) {
		return customerService.AddOrUpdateCustomer(c);
	}

	// Save or update
	@PutMapping("/{id}")
	public Customer saveOrUpdate(@RequestBody Customer newCustomer, @PathVariable Long id) {

		Customer old = new Customer();
		if (id != null) {
			old = customerService.findById(id);
			old.setName(newCustomer.getName());
			old.setAddress(newCustomer.getAddress());
			old.setPhoneNumber(newCustomer.getPhoneNumber());
			return customerService.AddOrUpdateCustomer(old);
		} else {
			return customerService.AddOrUpdateCustomer(newCustomer);
		}
	}
}
