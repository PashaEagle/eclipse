package main;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Component;

@Component
public interface SaleRepos extends MongoRepository<Sale, String>
{

}
