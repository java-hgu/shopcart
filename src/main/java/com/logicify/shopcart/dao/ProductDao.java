package com.logicify.shopcart.dao;

import java.sql.SQLException;
import java.util.Collection;

import com.logicify.shopcart.domain.Category;
import com.logicify.shopcart.domain.Product;

public interface ProductDao {
	public void addProduct(Product product) throws SQLException;
	public void updateProduct(Long prodid, Product product) throws SQLException;
	public Product getProductById(Long prodid) throws SQLException;
	public Collection<Product> getAllProducts() throws SQLException;
	public void deleteProduct(Product product) throws SQLException;
	public Collection<Product> getProductsByCategory(Category category) throws SQLException;
}
