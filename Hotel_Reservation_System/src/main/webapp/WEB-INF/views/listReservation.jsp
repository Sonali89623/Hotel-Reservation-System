<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="menu.jsp" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Reservations</title>
</head>
<body>
<h2>All Reservations..</h2>
<form action="listReservation" method="post">
<table border='1'>
<tr>
<th>Id</th>
<th>Name</th>
<th>City</th>
<th>Email</th>
<th>Mobile</th>
<th>Actions</th>
</tr>
<%ResultSet result=(ResultSet)request.getAttribute("result");%>
<%while(result.next()){ %>
<tr>
<td><%=result.getString(1) %></td>
<td><%=result.getString(2) %></td>
<td><%=result.getString(3) %></td>
<td><%=result.getString(4) %></td>
<td><%=result.getString(5) %></td>
<td><a href="delete?email=<%=result.getString(4)%>">delete</a>
<a href="update?email=<%=result.getString(4)%>&mobile=<%=result.getString(5)%>">update</a>
</td>
</tr>
<%} %>
</table>
</form>
</body>
</html>