<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<title>View Categories - Admin Panel</title>
    </head>
    <body>
        <div class="header"> 
        	<p><center>Hello! This is admin interface for product/category module for online shoping cart</center></p>
        </div>
        
        <div class="menu">
        	<div class="undermenu"><a href="${pageContext.request.contextPath}/admin?action=viewprod">View products</a></div>
        	<div class="undermenu"><a href="${pageContext.request.contextPath}/admin?action=viewcat">View categories</a></div>
        	<div class="undermenu"><a href="${pageContext.request.contextPath}/admin?action=addprod">Add a product</a></div>
        	<div class="undermenu"><a href="${pageContext.request.contextPath}/admin?action=addcat">Add a category</a></div>
        </div>
        
        <div class="content">
        	<div style="width: 40%; height: 300px; overflow-y: scroll; margin: 10px auto;">
	        	<c:forEach var="category" items="${categories}">
					<a href="#"><c:out value="${category.name}" /></a><br>
				</c:forEach>
			</div>	
        </div>
    </body>
</html>


		