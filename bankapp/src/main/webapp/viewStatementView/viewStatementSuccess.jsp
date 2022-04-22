<%@page import="java.util.Iterator"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dxc.bankapp.entity.Transaction"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/bankapp/main.css">
<meta charset="ISO-8859-1">
<title>View Statement Page</title>
</head>
<body>
	<h2>Transaction List</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Description</th>
				<th scope="col">Type</th>
				<th scope="col">Amount ($)</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Transaction> tList = (List<Transaction>) session.getAttribute("data");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
			Iterator it = tList.iterator();
			while (it.hasNext()) {
				Transaction t = (Transaction) it.next();
			%>
			<tr>
				<td><%=dateFormat.format(t.getTx_date())%></td>
				<td><%=t.getNotes()%></td>
				<td><%=t.getType()%></td>
				<td><%=t.getAmount()%></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>