<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src='js/nav.js' type='text/javascript'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"> </script>
</head>
<body>

<header>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../BigBoxWeb3/Welcome.jsp">BigBox App</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="../BigBoxWeb3/listAllStoresServlet">ALL STORES</a></li>
      <li><a href="../BigBoxWeb3/StoresByDivisionServlet ">STORES BY DIVISION</a></li>
	  <li ><a href="../BigBoxWeb3/AddStores.jsp">ADD STORE</a></li>
	  <li ><a href="../BigBoxWeb3/UpdateStores.jsp">UPDATE STORE</a></li>
	  <li ><a href="../BigBoxWeb3/DeleteStores.jsp">DELETE STORE</a></li>
	  <li ><a href="../BigBoxWeb3/AllDivisionsServlet">ALL DIVISIONS</a></li>
	  <li ><a href="../BigBoxWeb3/AddDivisions.jsp">ADD DIVISION</a></li>
	  <li ><a href="../BigBoxWeb3/DeleteDivisions.jsp">DELETE DIVISION</a></li>
	  <li ><a href="../BigBoxWeb3/SalesServlet">SALES</a></li>
	  </ul>
	  <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${sessionScope.user.userName}</a></li>
       <li><a href="../BigBoxWeb3/index.jsp"><span class="glyphicon glyphicon-log-out" name = "exit" value = "logOut"></span> Exit</a></li>
    </ul>
  </div>
</nav> 
</header>
</body>
<nav></nav>