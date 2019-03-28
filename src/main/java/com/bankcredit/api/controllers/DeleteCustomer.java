package com.bankcredit.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankcredit.api.exception.CustomerException;
import com.bankcredit.api.service.CustomerService;

@RestController
public class DeleteCustomer {
	
	private static Logger logger = LoggerFactory.getLogger(DeleteCustomer.class);
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/delete")
	public ResponseEntity<Void> deleteCustomer(@RequestParam Long id) throws CustomerException {
		logger.debug("Solicitud de eliminación del cliente: {}", id);
		service.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
