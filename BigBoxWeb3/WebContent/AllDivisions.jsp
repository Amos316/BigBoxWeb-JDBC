<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
<title>All Divisions</title>
</head>
<body>

	<h1>
		<em>All Divisions</em>
	</h1>

	<h4>${sessionScope.user.firstName}${sessionScope.user.lastName},
		these are the list of all divisions.</h4>

	<table class="table">
		<tr>
			
			<th>Division ID</th>
			<th>Division Number</th>
			<th>Name</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Zip code</th>


		</tr>
		<c:forEach var="d" items="${divisions}" >
		<tr>

			
			

			<td><c:out value="${d.id}" /></td>
			<td><c:out value="${d.divNum}" /></td>
			<td><c:out value="${d.name}" /></td>
			<td><c:out value="${d.address}" /></td>
			<td><c:out value="${d.city}" /></td>
			<td><c:out value="${d.state}" /></td>
			<td><c:out value="${d.zip}" /></td>



		</tr>
		</c:forEach>
	</table>

</body>
</html>