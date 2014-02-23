<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<title>Add Product - Admin Panel</title>
    </head>
    <body>
        <div class="header"> 
        	<p><center>Hello! This is admin interface for product/category module for online shoping cart</center></p>
        </div>
        
        <div class="menu">
        	<div class="undermenu"><a href="${pageContext.request.contextPath}/admin/viewprod">View products</a></div>
        	<div class="undermenu"><a href="${pageContext.request.contextPath}/admin/viewcat">View categories</a></div>
        	<div class="undermenu"><a href="${pageContext.request.contextPath}/admin/addprod">Add a product</a></div>
        	<div class="undermenu"><a href="${pageContext.request.contextPath}/admin/addcat">Add a category</a></div>
        </div>
        
        <div class="content">
        	<form method="post" action="addprod">	
        			<select multiple="multiple" size="5" name="selectcat">
        				<c:forEach var="category" items="${categories}">
							<option selected value="<c:out value="${category.id}" />"><c:out value="${category.name}" /></option>
						</c:forEach>
					</select>
					
        			<p>Name: </p> <input type="text" name="prodname" value="">
        			<p>Description: </p>  <textarea name="proddesc" cols="30" rows="2"></textarea>
        			<br>
        			<input type="submit" value="Add product" >
        		</form>
        </div>
    </body>
</html>