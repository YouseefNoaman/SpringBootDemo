package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ErrorDetail;

public interface ErrorDetailService {
	
	ErrorDetail findById(Long id);
	ErrorDetail DeleteCustomer(Long id);
	ErrorDetail AddOrUpdateErrorDetail(ErrorDetail e);
	List<ErrorDetail> getAll();
	
}
