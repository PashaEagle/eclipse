package saleAppSQL.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import saleAppSQL.model.Sale;
import saleAppSQL.repository.SaleRepository;

@Component
public class SaleService
{
	@Autowired
	SaleRepository saleRepository;

	public Iterable<Sale> getAllSales()
	{
		return saleRepository.findAll();
	}

	public void addSale(Sale sale)
	{
		saleRepository.save(sale);
	}

	public Sale getSaleById(String id)
	{
		Optional<Sale> saleOptional = saleRepository.findById(id);
		return saleOptional.orElse(null);
	}

	public void updateSale(String id, Sale sale)
	{
		Optional<Sale> optionalSale = saleRepository.findById(id);
		if (optionalSale.isPresent())
		{
			Sale changingSale = optionalSale.get();
			if (sale.getName() != null)
			{
				changingSale.setName(sale.getName());
			}
			if (sale.getPrice() != null)
			{
				changingSale.setPrice(sale.getPrice());
			}
			
			//changingSale.setDurationInMinutes(sale.getDurationInMinutes());
			saleRepository.save(changingSale);
		}
	}

	public void deleteSale(String id)
	{
		saleRepository.deleteById(id);
	}

}
