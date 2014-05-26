package com.logicify.shopcart.util;

import java.text.Annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.logicify.shopcart.logic.Factory;


public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final Session session = sessionFactory.openSession();

	private static SessionFactory buildSessionFactory() {
		try {
			System.err.println("Session builded");
			return new AnnotationConfiguration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session getSession() {
		return session;
	}
	/*public static void closeSession() {
		if(session != null && session.isOpen()) {
			session.close();
		}
	}*/
}
