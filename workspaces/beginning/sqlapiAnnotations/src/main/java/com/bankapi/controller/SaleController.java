package com.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankapi.model.Sale;
import com.bankapi.repository.SaleRepository;

@Controller    // This means that this class is a Controller
@ComponentScan
@RequestMapping(path="/sale")
public class SaleController {

	@Autowired
	private SaleRepository saleRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewSale (@RequestParam String name
		, @RequestParam String price) {
	// @ResponseBody means the returned String is the response, not a view name
	// @RequestParam means it is a parameter from the GET or POST request
	
	Sale n = new Sale();
	n.setName(name);
	n.setPrice(price);
	saleRepository.save(n);
	return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Sale> getAllSales() {
	// This returns a JSON or XML with the users
	return saleRepository.findAll();
	}
}
