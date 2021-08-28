package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;
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
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<?> resourceNotFoundException(RuntimeException ex, WebRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), HttpStatus.NOT_FOUND.value(),
				request.getDescription(false), new Date());
		errorDetailService.AddOrUpdateErrorDetail(errorDetails);
		return new ResponseEntity<>(errorDetails.toString(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				request.getDescription(false), new Date());
		errorDetailService.AddOrUpdateErrorDetail(errorDetails);
		return new ResponseEntity<>(errorDetails.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
//	   Map<String, String> errors = new HashMap<>();
//	   ex.getBindingResult().getFieldErrors().forEach(error ->
//	           errors.put(error.getField(), error.getDefaultMessage()));
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getDescription(false), new Date());
		errorDetailService.AddOrUpdateErrorDetail(errorDetails);
		return new ResponseEntity<>(errorDetails.toString(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(NotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<?> handleBookNotFound(NotFound ex, WebRequest request) {
		ErrorDetail errorDetails = new ErrorDetail(ex.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getDescription(false), new Date());
		errorDetailService.AddOrUpdateErrorDetail(errorDetails);
		return new ResponseEntity<>(errorDetails.toString(), HttpStatus.NOT_FOUND);
	}

}
