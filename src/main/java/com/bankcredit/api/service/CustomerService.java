package com.bankcredit.api.service;

import java.util.List;

import com.bankcredit.api.exception.CustomerException;
import com.bankcredit.api.model.Customer;

public interface CustomerService {
	
	 /**
	  * Devuelve todos los clientes
	  * @return lista de clientes
	  */
	List<Customer> getAllCustomer();
	
	/**
	 * Crea un nuevo cliente
	 * @param customer
	 * @return el nuevo cliente
	 * @throws CustomerException 
	 */
	Customer postCustomer(Customer customer) throws CustomerException;
	
	/**
	 * Actualiza un cliente 
	 * @param id
	 * @throws CustomerException 
	 */
	void putCustomer(Customer customer) throws CustomerException;
	
	/**
	 * Detela un cliente 
	 * @param id
	 * @throws CustomerException 
	 */
	void deleteCustomer(Long id) throws CustomerException;
}
