package com.bankcredit.api.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankcredit.api.exception.CustomerException;
import com.bankcredit.api.model.Customer;
import com.bankcredit.api.repository.CustomerRepository;
import com.bankcredit.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public List<Customer> getAllCustomer() {
		logger.info("Obteniendo el listado de los clientes");
		return repository.findAll();
	}

	@Override
	public Customer postCustomer(Customer customer) throws CustomerException {
		try {
			
			return repository.saveAndFlush(customer);
		} catch (Exception cex) {
			throw new CustomerException("Erro al gravar el cliente: ", cex.getCause());
		}
		
	}

	@Override
	public void putCustomer(Customer customer) throws CustomerException  {
		logger.info("Actualización del cliente: {}", customer.getName());
		Customer customerBDD = repository.findById(customer.getId())
					.orElseThrow(() -> new CustomerException("No ha sido posible encontrar el cliente"));
		
		repository.saveAndFlush(buildCustomer(customerBDD, customer));
	}

	@Override
	public void deleteCustomer(Long id) throws CustomerException {
		logger.info("Solicitud de eliminación del cliente: {}", id);
		repository.deleteById(id);
	}
	
	private Customer buildCustomer(Customer customerBDD, Customer customerRequest) {
		customerBDD.setDocument(customerRequest.getDocument());
		customerBDD.setSurname(customerRequest.getSurname());
		customerBDD.setName(customerRequest.getName());
		customerBDD.setAccounts(customerRequest.getAccounts());
		return customerBDD;
	}
	
}
