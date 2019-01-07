package com.app.dao.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.app.dao.interfaces.ProductDao;
import com.app.dao.models.Product;

public class ProductDaoImpl implements ProductDao {
	private static final String QUERY_INSERT = "INSERT INTO Products (name, producer, price) VALUES (?,?,?)";
	private static final String QUERY_UPDATE = "UPDATE Products SET name = ?, producer = ?, price = ? WHERE id = ?";
	private static final String QUERY_SELECT_ALL = "SELECT * FROM Products";
	private static final String QUERY_SELECT_BY_ID = "SELECT * FROM Products WHERE id = ?";
	private static final String QUERY_DELETE_BY_ID = "DELETE FROM Products WHERE id = ?";

	@Autowired
	@Qualifier("secondDBTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Product product) {
		jdbcTemplate.update(QUERY_INSERT, product.getName(), product.getProducer(), product.getPrice());
	}

	@Override
	public void remove(Integer id) {
		jdbcTemplate.update(QUERY_DELETE_BY_ID, id);
	}

	@Override
	public void update(Product product) {
		jdbcTemplate.update(QUERY_UPDATE, product.getName(), product.getProducer(), product.getPrice(), product.getId());
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = jdbcTemplate.query(QUERY_SELECT_ALL, new ProductMapper());
		return products;
	}

	@Override
	public Product getById(Integer id) {
		Product product = (Product) jdbcTemplate.queryForObject(QUERY_SELECT_BY_ID, new Object[] { id }, new ProductMapper());
		return product;
	}

	private class ProductMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setProducer(rs.getString("producer"));
			product.setPrice(rs.getDouble("price"));
			return product;
		}

	}
	

}
