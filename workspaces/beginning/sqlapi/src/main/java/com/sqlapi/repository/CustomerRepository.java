package com.sqlapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sqlapi.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
	List<Customer> findAll();
}
