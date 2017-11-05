<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE A STORE</title>
</head>
<body>
	<h3>
		<B>Enter new details for the store below.</B>
	</h3>
	<p>
		<i>${message}</i>
	</p>
	<form action="UpdateStoresServlet" method="post">
		<input type="hidden" name="action" value="add"> <label
			class="pad_top">Store Number to be updated:</label> <input
			type="text" name="StoreNumber" value="${store.storeNumber}" required><br>
		<label>&nbsp;</label> <label>&nbsp;</label> <label>&nbsp;</label> <label
			class="pad_top">Division ID:</label> <input type="divisionID"
			name="divisionID" value="${store.divisionID}" required><br>
		<label class="pad_top"> new sales amount:</label> <input type="text"
			name="sales" value="${store.sales}" required><br> <label
			class="pad_top"> New Name:</label> <input type="text" name="name"
			value="${store.name}" required><br> <label
			class="pad_top">New Address:</label> <input type="text"
			name="address" value="${store.address}" required><br> <label
			class="pad_top">City:</label> <input type="text" name="city"
			value="${store.city}" required><br> <label
			class="pad_top">State:</label> <input type="text" name="state"
			value="${store.state}" required><br> <label
			class="pad_top">Zip Code:</label> <input type="text" name="zip"
			value="${store.zip}" required><br> <label>&nbsp;</label>
		<input type="submit" value="Update" class="margin_right">
	</form>
</body>
</html>