package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pasha
 *
 */

@RestController
@ComponentScan
public class SaleController
{
	@Autowired
	private SaleServiceImpl saleService;

	@RequestMapping(value = "/get", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@GetMapping("/get")
	public List<Sale> getAllSales()
	{
		return saleService.getAllSales();
		/*if (sales.isEmpty())
		{
			return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
		} else
		{
			return new ResponseEntity(sales, HttpStatus.OK);
		}*/
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	//@PostMapping("/create")
	public void addSale(@RequestBody Sale sale)
	{
		
		saleService.addSale(sale);
	}

}
