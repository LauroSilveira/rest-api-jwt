package com.bankcredit.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankcredit.api.exception.CustomerException;
import com.bankcredit.api.model.Customer;
import com.bankcredit.api.service.CustomerService;

@RestController
@RequestMapping("/getCustomer")
public class CustumerController {
	
	
	private static Logger logger = LoggerFactory.getLogger(CustumerController.class);
	@Autowired
	private CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		logger.debug("Solicitud del listado de clientes");
		return new ResponseEntity<>(service.getAllCustomer(), HttpStatus.FOUND);
	}
	
	@PutMapping
	public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer) throws CustomerException {
		logger.debug("Se ha recibida una solicitud de actualización del cliente: {}", customer.getName());
		service.putCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) throws CustomerException {
		logger.info("Solicitud de creación de nuevo customer");
		return new ResponseEntity<>(service.postCustomer(customer), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteCustomer(@RequestParam Long id) throws CustomerException {
		logger.debug("Solicitud de eliminación del cliente: {}", id);
		service.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
