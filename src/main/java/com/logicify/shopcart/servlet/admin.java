package com.logicify.shopcart.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logicify.shopcart.domain.Category;
import com.logicify.shopcart.logic.AdminActionHandler;
import com.logicify.shopcart.logic.Factory;
import com.logicify.shopcart.domain.Product;


public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public admin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String action = "";
		if(request.getParameter("action") != null)
			action = request.getParameter("action");
		
		switch(action) {
			case "viewprod": {
				try {
					Collection<Product> products = Factory.getInstance().getProductDao().getAllProducts();
					request.setAttribute("products", products);
					request.getRequestDispatcher("/admin/viewprod.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			case "viewcat": {
		  		try {
					Collection<Category> categories = Factory.getInstance().getCategoryDao().getAllCategories();
					request.setAttribute("categories", categories);
					request.getRequestDispatcher("/admin/viewcat.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		  		break;
			}
			case "addprod": {
				try {
					Collection<Category> categories = Factory.getInstance().getCategoryDao().getAllCategories();
					request.setAttribute("categories", categories);
					request.getRequestDispatcher("/admin/addprod.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
			case "addcat": {
				request.getRequestDispatcher("/admin/addcat.jsp").forward(request, response);
				break;
			}
			default: {
				request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
				break;
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		AdminActionHandler handler = new AdminActionHandler(action, request, response);
	}

}
