package saleAppSQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import saleAppSQL.model.Sale;
import saleAppSQL.service.SaleService;
import saleAppSQL.util.EmptyJsonResponse;

@Controller
@ComponentScan
@RequestMapping("/sale")
public class SaleController
{
	@Autowired
	SaleService saleService;

	@RequestMapping(value = "/get", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Sale> getAllSales()
	{
		return saleService.getAllSales();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addSale(@RequestBody Sale sale)
	{
		saleService.addSale(sale);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	public ResponseEntity getSaleById(@PathVariable String id)
	{
		Sale sale = saleService.getSaleById(id);
		if (sale == null)
		{
			return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
		} else
		{
			return new ResponseEntity(sale, HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity update(@PathVariable String id, @RequestBody Sale requestSale)
	{
		saleService.updateSale(id, requestSale);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity deleteSale(@PathVariable String id)
	{
		//String ID = id.toHexString();
		saleService.deleteSale(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
