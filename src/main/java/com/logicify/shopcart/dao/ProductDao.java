package com.logicify.shopcart.dao;

import java.sql.SQLException;
import java.util.Collection;

import com.logicify.shopcart.logic.Category;
import com.logicify.shopcart.logic.Product;

public interface ProductDao {
	public void addProduct(Product product) throws SQLException;
	public void updateProduct(Long prodid, Product product) throws SQLException;
	public Product getProductById(Long prodid) throws SQLException;
	public Collection getAllProducts() throws SQLException;
	public void deleteProduct(Product product) throws SQLException;
	public Collection getProductsByCategory(Category category) throws SQLException;
}
