package com.bankcredit.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankcredit.api.exception.CustomerException;
import com.bankcredit.api.model.Customer;
import com.bankcredit.api.service.CustomerService;

@RestController
public class PutCustomer {
	
	private static Logger logger = LoggerFactory.getLogger(PutCustomer.class);
	
	@Autowired
	private CustomerService service;
	
	@PutMapping("/putCustomer")
	public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer) throws CustomerException {
		logger.debug("Se ha recibida una solicitud de actualización del cliente: {}", customer.getName());
		service.putCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}
