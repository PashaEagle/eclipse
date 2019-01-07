package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.dao.interfaces.ProductDao;
import com.app.dao.models.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public List<Product> allProducts() {
		return productDao.getAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
	public Product getProduct(@PathVariable Integer id) {
		return productDao.getById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public void addProduct(@RequestBody Product product) {
		productDao.add(product);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/products/")
	public void updateProduct(@RequestBody Product product) {
		productDao.update(product);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		productDao.remove(id);
	}
}

