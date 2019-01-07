package com.bankapi.service;

import java.util.List;

import com.bankapi.entity.Bank;

public interface BankService {

	Bank addBank(Bank bank);

	void delete(long id);

	Bank getByName(String name);

	Bank editBank(Bank bank);

	List<Bank> getAll();
}
