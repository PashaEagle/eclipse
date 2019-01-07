package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SaleServiceImpl implements SaleService
{
	@Autowired
	private SaleRepos saleRepository;

	@Override
	public void addSale(Sale sale)
	{
		saleRepository.save(sale);
	}

	@Override
	public List<Sale> getAllSales()
	{
		return saleRepository.findAll();
	}

	@Override
	public Sale getSaleById(String id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSale(String id, Sale sale)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSale(String id)
	{
		// TODO Auto-generated method stub
		
	}
}
