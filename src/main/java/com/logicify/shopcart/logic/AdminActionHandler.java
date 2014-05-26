package com.logicify.shopcart.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logicify.shopcart.domain.Category;
import com.logicify.shopcart.domain.Product;

public class AdminActionHandler {
	public AdminActionHandler(String action, HttpServletRequest request, HttpServletResponse response) {
		switch(action) {
		case "addprod": {
			String prodname = request.getParameter("prodname");
			String proddesc = request.getParameter("proddesc");
			String[] selectcat = request.getParameterValues("selectcat");
			if(!prodname.isEmpty() && !proddesc.isEmpty()) {
				
				
				
				Set<Category> cats = new HashSet<Category>();
				
				for(int i = 0; i < selectcat.length; i++) {
					Category cat = new Category();
					cat.setId(Long.parseLong(selectcat[i]));
					cats.add(cat);
				}
				
				Product prod = new Product();
				prod.setName(prodname);
				prod.setDescription(proddesc);
				prod.setCategories(cats);
						
				response.setContentType("text/html");
				try {
					Factory.getInstance().getProductDao().addProduct(prod);
					request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		}
		case "addcat": {
			String catname = request.getParameter("catname");
			String catdesc = request.getParameter("catdesc");
			
			if(!catname.isEmpty() && !catdesc.isEmpty()) {
			
				Category cat = new Category();
				cat.setName(catname);
				cat.setDescription(catdesc);
						
				response.setContentType("text/html");
				try {
					Factory.getInstance().getCategoryDao().addCategory(cat);
					request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		}
		default: {
			
			break;			
		}
	}
	}
}
