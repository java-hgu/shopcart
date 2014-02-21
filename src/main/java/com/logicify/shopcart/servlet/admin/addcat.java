package com.logicify.shopcart.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logicify.shopcart.logic.Category;
import com.logicify.shopcart.logic.Factory;

public class addcat extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addcat() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/addcat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String catname = request.getParameter("catname");
		String catdesc = request.getParameter("catdesc");
		out.println(catname + " " + catdesc);
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
			}
		}
	}

}
