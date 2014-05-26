package com.logicify.shopcart.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import com.logicify.shopcart.domain.Category;
import com.logicify.shopcart.domain.Product;
import com.logicify.shopcart.dao.CategoryDao;
import com.logicify.shopcart.util.HibernateUtil;

public class CategoryDaoImpl implements CategoryDao {
	
	public void addCategory(Category category) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error: insert error (addCategory) " + e.getMessage());
		}
	}

	public void updateCategory(Long catid, Category category) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error: update error (updateCategory) " + e.getMessage());
		}
	}

	public Category getCategoryById(Long catid) throws SQLException {
		Session session = null;
		Category category = null;
		
		try {
			session = HibernateUtil.getSession();
			category = (Category) session.get(Category.class, catid);
		} catch (Exception e) {
			System.err.println("Error: findById error (getCategoryById) " + e.getMessage());
		}
		
		return category;
	}

	public Collection<Category> getAllCategories() throws SQLException {
		Session session = null;
		List<Category> categories = new ArrayList<Category>();
		
		try {
			session = HibernateUtil.getSession();
			categories = session.createCriteria(Category.class).list();
			
		} catch (Exception e) {
			System.err.println("Error: getAll error (getAllCategories) " + e.getMessage());
		}
		
		return categories;
	}

	public void deleteCategory(Category category) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error: delete error (deleteCategory) " + e.getMessage());
		}
	}

	public Collection<Category> getCategoriesByProduct(Product product) throws SQLException {
		Session session = null;
		List<Category> categories = new ArrayList<Category>();
		
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			Long prodid = product.getId();
			Query query = session.createQuery("SELECT c FROM Category c INNER JOIN c.Product product WHERE product.prodid = :prodid")
					.setLong("prodid", prodid);
			categories = (List<Category>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error: select error (getCategoriesByProduct) " + e.getMessage());
		}
		return categories;
	}
	
}
