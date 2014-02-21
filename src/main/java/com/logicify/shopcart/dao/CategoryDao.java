package com.logicify.shopcart.dao;

import java.sql.SQLException;
import java.util.Collection;

import com.logicify.shopcart.logic.Product;
import com.logicify.shopcart.logic.Category;

public interface CategoryDao {
	public void addCategory(Category category) throws SQLException;
	public void updateCategory(Long catid, Category category) throws SQLException;
	public Category getCategoryById(Long catid) throws SQLException;
	public Collection getAllCategories() throws SQLException;
	public void deleteCategory(Category category) throws SQLException;
	public Collection getCategoriesByProduct(Product product) throws SQLException;
}
