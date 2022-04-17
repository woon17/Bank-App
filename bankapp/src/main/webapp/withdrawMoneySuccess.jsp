<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Money Success Page</title>
</head>
<body>
Withdrawal successful. Your balance is now $<%out.print(session.getAttribute("balance"));%>.
	<form action="/bankapp/customerLoginSuccess.jsp">
		<input type="submit" value="Back to Home">
	</form>
</body>
</html>