<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/bankapp/main.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="logout">
		<form action="/bankapp/Logout" method="get">
			<br> <input type="submit" value="Logout" />
		</form>
	</div>

	<h1 id="wecomeMessage">
		Welcome,
		<%
	// println in broswer, in client machine. not in console
	HttpSession ses = request.getSession();
	out.println(ses.getAttribute("cusUserName"));
	/* ses.getAttribute("un") */
	%>
	</h1>
	<div class="container loginSuccess">
		<div>
			<h3>What would you like to do?</h3>
			<ul>
				<li><button type="button">
						<a href="/bankapp/changePassword.html">Change password</a>
					</button></li>
				<li><button type="button">
						<a href="/bankapp/withdrawMoney.html">Withdraw Money</a>
					</button></li>
				<li><button type="button">
						<a href="/bankapp/applyLoan.html">Apply for Loan</a>
					</button></li>
				<li><button type="button">
						<a href="/bankapp/viewStatement.html">View statement</a>
					</button></li>
				<li><button type="button">
						<a href="/bankapp/CheckBalance">Check balance</a>
					</button></li>
			</ul>

		</div>
	</div>



</body>
</html>