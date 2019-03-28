package com.bankcredit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankcredit.api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
