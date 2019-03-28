package com.bankcredit.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankcredit.api.model.Customer;
import com.bankcredit.api.service.CustomerService;

@RestController
public class GetCustomer {
	
	private static Logger logger = LoggerFactory.getLogger(GetCustomer.class);
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/getCustomer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		logger.debug("Solicitud del listado de clientes");
		return new ResponseEntity<>(service.getAllCustomer(), HttpStatus.FOUND);
	}
	
}
