package com.app.dao.interfaces;

import java.util.List;

import com.app.dao.models.Product;

public interface ProductDao {

	void add(Product product);
	void remove(Integer id);
	void update(Product product);
	List<Product> getAll();
	Product getById(Integer id);
}
