package com.logicify.shopcart.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logicify.shopcart.logic.Category;
import com.logicify.shopcart.logic.Factory;
import com.logicify.shopcart.logic.Product;

public class addprod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addprod() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Collection categories = Factory.getInstance().getCategoryDao().getAllCategories();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/admin/addprod.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String prodname = request.getParameter("prodname");
		String proddesc = request.getParameter("proddesc");
		String[] selectcat = request.getParameterValues("selectcat");
		if(!prodname.isEmpty() && !proddesc.isEmpty()) {
			
			
			
			Set cats = new HashSet();
			
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
			}
		}
	}

}
