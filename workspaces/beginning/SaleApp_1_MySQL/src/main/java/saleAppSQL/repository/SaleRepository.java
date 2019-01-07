package saleAppSQL.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import saleAppSQL.model.Sale;

@Component
public interface SaleRepository extends CrudRepository<Sale, ObjectId>
{

}
