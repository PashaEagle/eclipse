package com.bankapi.controller;

import java.util.List;

//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankapi.entity.Bank;
import com.bankapi.service.BankService;


@RestController
@ComponentScan
@RequestMapping("/bank")
public class BankController {

	@Autowired
	BankService bankService;
	
	/*@RequestMapping(value = "/getall", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Bank> getAllSales()
	{
		return saleService.getAllSales();
	}*/

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addBank(@RequestBody Bank bank)
	{
		bankService.addBank(bank);
	}

	/*@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	public Sale findById(@PathVariable ObjectId id)
	{
		return saleService.findById(id);
		
	}*/

	
}
