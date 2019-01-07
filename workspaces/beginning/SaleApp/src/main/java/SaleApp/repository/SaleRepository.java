package SaleApp.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import SaleApp.model.Sale;

@Component
public interface SaleRepository extends MongoRepository<Sale, String>
{
	Sale findById(ObjectId id);
}