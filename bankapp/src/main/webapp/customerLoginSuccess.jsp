<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="float: right">
		<form action="/bankapp/Logout" method="get">
			<br> <input type="submit" value="Logout" />
		</form>
	</div>
	<p>
		<span>Welcome customer</span>,
		<%
		// println in broswer, in client machine. not in console
		HttpSession ses = request.getSession();
		out.println(ses.getAttribute("cusUserName"));
		/* ses.getAttribute("un") */
		%>. You login successfully
	</p>

	<a href="/bankapp/changePassword.html">change password</a>
	<br>
	<a href="/bankapp/withdrawMoney.html">Withdraw Money</a>
	<br>
	<a href="/bankapp/applyLoan.html">Apply for Loan</a>
	<br>
	<a href="/bankapp/viewStatement.html">View statement</a>

</body>
</html>