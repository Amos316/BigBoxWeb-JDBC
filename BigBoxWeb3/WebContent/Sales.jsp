<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales by Division</title>
</head>
<body>
<h4>SELECT A DIVISION, FOR ITS SALES </h4>
<h4>OR SELECT TOTAL SALES.</h4>
<p></p>
<br/><h3><i>${message}</i></h3>
<br/><form action="SalesServlet" method="post">
        <input type="hidden" name="action" value="add"> 

       <input type="radio" value="DIV001" name = "id1" class="margin_right"><B>DIV 001</B><br/>
        <input type="radio" value="DIV111" name = "id1" class="margin_right"><B>DIV 111</B><br/>
        <input type="radio" value="TOTALSALES" name = "id1" class="margin_right"><B>TOTAL SALES</B><br/>
         <label>&nbsp;</label>
       <br/> <input type="submit" value="Go" class="margin_right">
    </form>
</body>
</html>