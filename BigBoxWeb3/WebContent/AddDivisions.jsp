<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Division</title>
</head>
<body>
	<h3>Enter new division information.</h3>
	<p>
		<i>${message}</i>
	</p>
	<form action="WelcomeServlet" method="post">
		<input type="hidden" name="action" value="add"> <label
			class="pad_top">Division ID:</label> <input type="divisionID"
			name="dID" value="${division.divisionID}" required><br>
		<label class="pad_top">Division Number:</label> <input type="text"
			name="dNum" value="${Division.divNum}" required><br> <label
			class="pad_top">Division Name:</label> <input type="text"
			name="dname" value="${Division.name}" required><br> <label
			class="pad_top">Address:</label> <input type="text" name="daddress"
			value="${Division.address}" required><br> <label
			class="pad_top">City:</label> <input type="text" name="dcity"
			value="${Division.city}" required><br> <label
			class="pad_top">State:</label> <input type="text" name="dstate"
			value="${Division.state}" required><br> <label
			class="pad_top">Zip Code:</label> <input type="text" name="dzip"
			value="${Division.zip}" required><br> <label>&nbsp;</label>
		<input type="submit" value="send" class="margin_right">
	</form>
</body>
</html>