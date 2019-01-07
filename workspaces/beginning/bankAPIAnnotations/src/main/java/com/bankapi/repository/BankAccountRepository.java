package com.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapi.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}
