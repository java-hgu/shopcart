<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<title>Add Category - Admin Panel</title>
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
        	<form id="myform" method="post" action="addcat">
        			<p>Name: </p> <input type="text" name="catname" value="">
        			<p>Description: </p>  <textarea name="catdesc" cols="40" rows="3"></textarea>
        			
        			<input type="submit" value="Add category" >
        		</form>
        </div>
    </body>
</html>


		