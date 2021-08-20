package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.example.demo.entity.ErrorDetail;
import com.example.demo.service.impl.ErrorDetailServiceIMPL;

@RestControllerAdvice
public class GlobalExceptionHandler {

	ErrorDetailServiceIMPL errorDetailService;

	@Autowired
	public GlobalExceptionHandler(ErrorDetailServiceIMPL errorDetailService) {
		super();
		this.errorDetailService = errorDetailService;
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> resourceNotFoundException(RuntimeException ex, WebRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), request.getDescription(false), new Date());
		errorDetailService.AddOrUpdateErrorDetail(errorDetails);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), request.getDescription(false), new Date());
		errorDetailService.AddOrUpdateErrorDetail(errorDetails);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
