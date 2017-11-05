<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp"></jsp:include>
<title>Add a Store</title>
</head>
<body>
	<h3>To add a store, enter information below.</h3>
	<p>
		<i>${message}</i>
	</p>
	<form action="AddstoresServlet" method="post">
		<input type="hidden" name="action" value="add"> <label
			class="pad_top">Division ID:</label> <input type="text"
			name="divisionID" value="${store.divNumber}" required><br>
		<label class="pad_top">Store Number:</label> <input type="text"
			name="StoreNumber" value="${store.storeNbr}" required><br>
		<label class="pad_top">sales:</label> <input type="text" name="sales"
			value="${store.sales2}" required><br> <label
			class="pad_top">Name:</label> <input type="text" name="name"
			value="${store.name}" required><br> <label
			class="pad_top">Address:</label> <input type="text" name="address"
			value="${store.address}" required><br> <label
			class="pad_top">City:</label> <input type="text" name="city"
			value="${store.city}" required><br> <label
			class="pad_top">State:</label> <input type="text" name="state"
			value="${store.state}" required><br> <label
			class="pad_top">Zip Code:</label> <input type="text" name="zip"
			value="${store.zipCode}" required><br> <label>&nbsp;</label>
		<input type="submit" value="Add" class="margin_right">
	</form>
</body>
</html>