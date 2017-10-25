<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"> </script>
<title>Welcome to Big Box App</title>

</head>
<body>
	<h1>BigBox Login Page</h1>
	<center>
		<h2> Login Info</h2>
		<p><i>${message}</i></p>
		<form action="UsersServlet" method="post" class ="form-horizontal">
		<input type="hidden" name="action" value="login" >
		<div class ="form-group">
		
		<label class="sr-only" for="username"></label>
		<br/>UserName:<input type="text" class="control-label" name="userName"  value ="${user.userName}" required>
		</div>
		<div class ="form-group">
		<label class="sr-only" for="password"></label>
		<br/>Password:<input type="password" class="control-label " name="password" value="${user.password}"   required>
		</div>
		<br/><label>&nbsp;</label>
		<br/><input type="submit" value="submit">
		
		
		</form>
	
	</center>
</body>
</html>