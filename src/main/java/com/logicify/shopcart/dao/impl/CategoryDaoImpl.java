package com.logicify.shopcart.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hsqldb.lib.Iterator;

import com.logicify.shopcart.logic.Category;
import com.logicify.shopcart.logic.Product;
import com.logicify.shopcart.dao.CategoryDao;
import com.logicify.shopcart.util.HibernateUtil;

public class CategoryDaoImpl implements CategoryDao {

	public void addCategory(Category category) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateCategory(Long catid, Category category) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Category getCategoryById(Long catid) throws SQLException {
		Session session = null;
		Category category = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			category = (Category) session.get(Category.class, catid);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		
		return category;
	}

	public Collection getAllCategories() throws SQLException {
		Session session = null;
		List categories = new ArrayList<Category>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			categories = session.createCriteria(Category.class).list();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		
		return categories;
	}

	public void deleteCategory(Category category) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'delete'", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Collection getCategoriesByProduct(Product product) throws SQLException {
		Session session = null;
		List categories = new ArrayList<Category>();
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			Long prodid = product.getId();
			Query query = session.createQuery("SELECT c FROM Category c INNER JOIN c.Product product WHERE product.prodid = :prodid")
					.setLong("prodid", prodid);
			categories = (List<Category>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'delete'", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return categories;
	}
	
}
