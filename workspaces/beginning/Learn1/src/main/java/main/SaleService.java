package main;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface SaleService
{
	List<Sale> getAllSales();
    Sale getSaleById(String id);
    //List<Route> getRoutesByFromAndTo(String from, String to);
    void addSale(Sale sale);
    void updateSale(String id, Sale sale);
    void deleteSale(String id);
}
