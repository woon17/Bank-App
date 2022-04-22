<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="/bankapp/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Withdraw Money Success Page</title>
</head>
<body>
	<div class="table table-light ">
		<form action="/bankapp/loginView/customerLoginSuccess.jsp">
			<button type="submit" class="btn btn-light" style="float: right">Back
				to home</button>
		</form>
	</div>
	<h1 class="text-white">Withdrawal successful. Your balance is now $<%out.print(session.getAttribute("balance"));%>.</h1>
	
	
	
	
</body>
</html>