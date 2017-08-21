<%@page import="java.util.List"%>
<%@page import="com.josh.collatz.model.CollatzWrapper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Collatz</title>
</head>

<body>

<h2>Collatz Conjecture Calculator</h2>

<form action="CollatzController" method="get">

Enter a Number: <input type="number" name="number" />

<input type="submit" name="Enter" />

</form>

<%
CollatzWrapper cw = (CollatzWrapper) request.getAttribute("cw");
if (cw == null) return;
%>

<h3>The number you entered (<%= cw.getNum() %>) takes the following <%= cw.getNumSteps() %> steps:</h3>

<%
for (long n : cw.getSteps()) {
	%>
	<li> <%= n %> </li>
	<%
}
%>

</body>

</html>
