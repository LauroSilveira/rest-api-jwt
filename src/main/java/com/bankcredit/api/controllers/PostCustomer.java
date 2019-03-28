package com.bankcredit.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankcredit.api.exception.CustomerException;
import com.bankcredit.api.model.Customer;
import com.bankcredit.api.service.CustomerService;

@RestController
public class PostCustomer {
	
	private static Logger logger = LoggerFactory.getLogger(PostCustomer.class);
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/create-customer")
	public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) throws CustomerException {
		logger.info("Solicitud de creación de nuevo customer");
		return new ResponseEntity<>(service.postCustomer(customer), HttpStatus.CREATED);
	}
}
