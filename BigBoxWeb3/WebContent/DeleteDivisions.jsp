<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete a Division</title>
</head>
<body>
	<h1>
		<em>Delete a Division</em>
	</h1>
	<p>Enter Division number to be deleted.</p>
	<p>
		<i>${message}</i>
	</p>
	<form action="DeleteDivisionServlet" method="post">
		<input type="hidden" name="action" value="add"> <label
			class="pad_top">Division Number:</label> <input type="text"
			name="Number" value="${divsion.divId}" required><br> <label>&nbsp;</label>
		<input type="submit" value="Delete" class="margin_right">
	</form>
</body>
</html>