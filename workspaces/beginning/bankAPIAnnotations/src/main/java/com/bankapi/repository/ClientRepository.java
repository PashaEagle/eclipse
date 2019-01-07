package com.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapi.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
