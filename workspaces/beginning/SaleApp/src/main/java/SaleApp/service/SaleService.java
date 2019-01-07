package SaleApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import SaleApp.model.Sale;
import SaleApp.repository.SaleRepository;

@Component
public class SaleService
{
	@Autowired
	private SaleRepository saleRepository;

	public List<Sale> getAllSales()
	{
		return saleRepository.findAll();
	}

	public void addSale(Sale sale)
	{
		saleRepository.save(sale);
	}

	public Sale findById(ObjectId id)
	{
		Sale saleOptional = saleRepository.findById(id);
		return saleOptional;//.orElse(null);
	}

	public void updateSale(Sale sale)
	{
		
			
			//changingSale.setDurationInMinutes(sale.getDurationInMinutes());
			saleRepository.save(sale);
		
	}

	public void deleteSale(String id)
	{
		saleRepository.deleteById(id);
	}

}
