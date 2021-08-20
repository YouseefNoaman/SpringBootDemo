package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ErrorDetail;
import com.example.demo.service.ErrorDetailService;
import com.example.demo.repository.ErrorDetailRepository;

@Service
public class ErrorDetailServiceIMPL implements ErrorDetailService {

	private final ErrorDetailRepository errorDetailRepository;

	@Autowired
	public ErrorDetailServiceIMPL(ErrorDetailRepository errorDetailRepository) {
		this.errorDetailRepository = errorDetailRepository;
	}

	@Override
	public ErrorDetail findById(Long id) {
		if (id != null)
			return errorDetailRepository.getById(id);
		return null;
	}

	@Override
	public ErrorDetail DeleteCustomer(Long id) {
		ErrorDetail e = new ErrorDetail();
		if (id != null)
			e = errorDetailRepository.getById(id);
		else {
			errorDetailRepository.delete(e);
			return e;
		}
		return null;
	}

	@Override
	public ErrorDetail AddOrUpdateErrorDetail(ErrorDetail e) {
		return errorDetailRepository.save(e);
	}

	@Override
	public List<ErrorDetail> getAll() {
		return errorDetailRepository.findAll();
	}
}
