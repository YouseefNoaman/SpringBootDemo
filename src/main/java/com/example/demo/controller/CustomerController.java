package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.impl.CustomerServiceIMPL;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

	private CustomerServiceIMPL customerService;

	@Autowired
	CustomerController(CustomerServiceIMPL customerService) {
		Objects.requireNonNull(customerService);
		this.customerService = customerService;
	}

	@GetMapping("/user")
	public ResponseEntity<String> user() {
		return ResponseEntity.ok("THIS IS USER");
	}

	@GetMapping("/admin")
	public ResponseEntity<String> admin() {
		return ResponseEntity.ok("THIS IS ADMIN");
	}

	@GetMapping("/all")
	public List<Customer> getALL() {
		return customerService.getAll();
	}
	
	@Operation(summary = "Get a customer by id")
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
	}

	@PostMapping("/")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer c) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.AddOrUpdateCustomer(c));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.DeleteCustomer(id));
	}

	@PutMapping("/")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer c) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.AddOrUpdateCustomer(c));

	}

	// Save or update
	@PutMapping("/{id}")
	public ResponseEntity<Customer> saveOrUpdate(@RequestBody Customer newCustomer, @PathVariable Long id) {

		Customer old = new Customer();
		if (id != null) {
			old = customerService.findById(id);
			old.setName(newCustomer.getName());
			old.setAddress(newCustomer.getAddress());
			old.setPhoneNumber(newCustomer.getPhoneNumber());

			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.AddOrUpdateCustomer(old));
		} else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.AddOrUpdateCustomer(newCustomer));
		}
	}
}
