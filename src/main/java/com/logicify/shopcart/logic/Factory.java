package com.logicify.shopcart.logic;

import com.logicify.shopcart.dao.CategoryDao;
import com.logicify.shopcart.dao.ProductDao;
import com.logicify.shopcart.dao.impl.CategoryDaoImpl;
import com.logicify.shopcart.dao.impl.ProductDaoImpl;

public class Factory {
	private static ProductDao productDao = null;
	private static CategoryDao categoryDao = null;
	private static Factory instance = null;
	
	public static synchronized Factory getInstance() {
		if(instance == null) {
			instance = new Factory();
		}
		return instance;
	}
	
	public CategoryDao getCategoryDao() {
		if(categoryDao == null) {
			categoryDao = new CategoryDaoImpl();
		}
		return categoryDao;
	}
	
	public ProductDao getProductDao() {
		if(productDao == null) {
			productDao = new ProductDaoImpl();
		}
		return productDao;
	}
}
