package com.logicify.shopcart.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import com.logicify.shopcart.dao.ProductDao;
import com.logicify.shopcart.logic.Category;
import com.logicify.shopcart.logic.Product;
import com.logicify.shopcart.util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	public void addProduct(Product product) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateProduct(Long prodid, Product product) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(prodid);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}

	public Product getProductById(Long prodid) throws SQLException {
		Session session = null;
		Product product = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			product = (Product) session.get(Product.class, prodid);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		
		return product;
	}

	public Collection getAllProducts() throws SQLException {
		Session session = null;
		List products = new ArrayList<Product>();
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			products = session.createCriteria(Product.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		
		return products;
	}

	public void deleteProduct(Product product) throws SQLException {
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'delete'", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Collection getProductsByCategory(Category category) throws SQLException {
		Session session = null;
		List products = new ArrayList<Product>();
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			Long catid = category.getId();
			Query query = session.createQuery("from Product p inner join p.categories cat where cat.id = :catid").setLong("catid", catid);
			products = (List<Product>) query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'select'", JOptionPane.OK_OPTION);
		} finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return products;
	}

}
