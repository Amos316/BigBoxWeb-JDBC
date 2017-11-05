<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Divisions</title>
</head>
<body>
	<h1>Stores list per division.</h1>
	<h4>Division 001</h4>
	<h4>Division 111</h4>
	<p>
	<form action="StoresByDivisionServlet" method="post">
		<input type="text" name="Division"> <input type="submit"
			value="submit">
	</form>
	<h4>List of Stores</h4>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table class="table">
		<tr>
			<th>ID</th>
			<th>Division ID</th>
			<th>Sales</th>
			<th>Store Number</th>
			<th>Name</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Zip code</th>
		</tr>
		<c:forEach var="s" items="${store}">
			<tr>
				<td><c:out value="${s.id}" /></td>
				<td><c:out value="${s.divID}" /></td>
				<td><c:out value="${s.sales}" />
				<td><c:out value="${s.storeNum}" /></td>
				<td><c:out value="${s.name}" /></td>
				<td><c:out value="${s.address}" /></td>
				<td><c:out value="${s.city}" /></td>
				<td><c:out value="${s.state}" /></td>
				<td><c:out value="${s.zip}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>