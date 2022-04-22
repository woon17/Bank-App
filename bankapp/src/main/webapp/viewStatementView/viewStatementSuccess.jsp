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

	<%
	List<Transaction> tList = (List<Transaction>) session.getAttribute("data");
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
	PrintWriter pw = response.getWriter();
	pw.write("----------------------------------------------------------------\n");
	pw.write("Date \t\tNOTES \t\tTYPE \tAMOUNT \tSTATUS\n");
	pw.write("----------------------------------------------------------------\n");
	for (Transaction t : tList) {
		pw.write(dateFormat.format(t.getTx_date()) + "\t" + t.getNotes() + "\t" + t.getType() + "\t" + t.getAmount() + "\t"
		+ t.getStatus() + "\n");
	}
	pw.write("----------------------------------------------------------------\n");
	%>

</body>
</html>