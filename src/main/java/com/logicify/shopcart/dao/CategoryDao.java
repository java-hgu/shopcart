package com.logicify.shopcart.dao;

import java.sql.SQLException;
import java.util.Collection;

import com.logicify.shopcart.domain.Product;
import com.logicify.shopcart.domain.Category;

public interface CategoryDao {
	public void addCategory(Category category) throws SQLException;
	public void updateCategory(Long catid, Category category) throws SQLException;
	public Category getCategoryById(Long catid) throws SQLException;
	public Collection<Category> getAllCategories() throws SQLException;
	public void deleteCategory(Category category) throws SQLException;
	public Collection<Category> getCategoriesByProduct(Product product) throws SQLException;
}
