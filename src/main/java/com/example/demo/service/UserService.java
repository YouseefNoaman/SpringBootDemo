package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService{
	
	User findById(Long id);
	User DeleteCustomer(Long id);
	User AddOrUpdateCustomer(User u);
	List<User> getAll();
	
}
