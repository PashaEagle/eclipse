package com.bankapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bankapi.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
}