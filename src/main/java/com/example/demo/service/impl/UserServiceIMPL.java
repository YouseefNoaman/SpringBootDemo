package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Util;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService{

	private final UserRepository userRepository;
	Util util = new Util();

	@Autowired
	public UserServiceIMPL(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		if (id != null)
			return userRepository.getById(id);
		return null;
	}

	@Override
	public User DeleteCustomer(Long id) {
		User u = new User();
		if (id != null) {
			u = userRepository.getById(id);
			userRepository.delete(u);
			return u;

		}
		return null;
	}

	@Override
	public User AddOrUpdateCustomer(User u) {
		return userRepository.save(u);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
}
