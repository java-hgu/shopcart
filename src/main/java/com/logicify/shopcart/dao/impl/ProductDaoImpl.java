package com.logicify.shopcart.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import com.logicify.shopcart.dao.ProductDao;
import com.logicify.shopcart.domain.Category;
import com.logicify.shopcart.domain.Product;
import com.logicify.shopcart.util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	public void addProduct(Product product) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error: insert error (addProduct) " + e.getMessage());
		} 
	}

	public void updateProduct(Long prodid, Product product) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(prodid);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error: update error (updateProduct) " + e.getMessage());
		}
		
	}

	public Product getProductById(Long prodid) throws SQLException {
		Session session = null;
		Product product = null;
		
		try {
			session = HibernateUtil.getSession();
			product = (Product) session.get(Product.class, prodid);
		} catch (Exception e) {
			System.err.println("Error: findById error (getProductById) " + e.getMessage());
		}
		
		return product;
	}

	public Collection<Product> getAllProducts() throws SQLException {
		Session session = null;
		List<Product> products = new ArrayList<Product>();
		
		try {
			session = HibernateUtil.getSession();
			products = session.createCriteria(Product.class).list();
		} catch (Exception e) {
			System.err.println("Error: getall error (getAllProducts) " + e.getMessage());
		}
		
		return products;
	}

	public void deleteProduct(Product product) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error: delete error (deleteProduct) " + e.getMessage());
		}
	}

	public Collection<Product> getProductsByCategory(Category category) throws SQLException {
		Session session = null;
		List<Product> products = new ArrayList<Product>();
		
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			Long catid = category.getId();
			Query query = session.createQuery("from Product p inner join p.categories cat where cat.id = :catid").setLong("catid", catid);
			products = (List<Product>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error: select error (getProductsByCategory) " + e.getMessage());
		}
		
		return products;
	}

}
