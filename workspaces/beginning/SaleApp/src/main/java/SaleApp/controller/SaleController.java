package SaleApp.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SaleApp.model.Sale;
import SaleApp.service.SaleService;
import SaleApp.util.EmptyJsonResponse;

@RestController
@ComponentScan
@RequestMapping("/sale")
public class SaleController
{
	@Autowired
	SaleService saleService;

	@RequestMapping(value = "/getall", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Sale> getAllSales()
	{
		return saleService.getAllSales();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addSale(@RequestBody Sale sale)
	{
		saleService.addSale(sale);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	public Sale findById(@PathVariable ObjectId id)
	{
		return saleService.findById(id);
		
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity update(@RequestBody Sale requestSale)
	{
		saleService.updateSale(	requestSale);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity deleteSale(@PathVariable String id)
	{
		// String ID = id.toHexString();
		saleService.deleteSale(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
