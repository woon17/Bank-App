<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="/bankapp/main.css">
<title>Withdraw Money Success Page</title>
</head>
<body>
<h1>Withdrawal successful. Your balance is now $<%out.print(session.getAttribute("balance"));%>.</h1>

	<div class="container withdrawError">
		<form action="/bankapp/customerLoginSuccess.jsp">
			<input type="submit" value="Back to Home">
		</form>
	</div>
	
</body>
</html>