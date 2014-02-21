package com.logicify.shopcart.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
		request.getRequestDispatcher("/admin/addprod.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String prodname = request.getParameter("prodname");
		String proddesc = request.getParameter("proddesc");
		if(!prodname.isEmpty() && !proddesc.isEmpty()) {
		
			Category cat = new Category();
			cat.setId(Long.parseLong("4"));
			Category cat2 = new Category();
			cat2.setId(Long.parseLong("3"));
			
			
			
			Product prod = new Product();
			prod.setName(prodname);
			prod.setDescription(proddesc);
			
			Set cats = new HashSet();
			cats.add(cat);
			cats.add(cat2);
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
