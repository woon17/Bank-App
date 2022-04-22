<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/bankapp/main.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/bankapp/Logout" method="get">
			<button type="submit" class="btn btn-light" style="float: right">Logout</button>
		</form>
	</div>

	<h4 class="text-white" align="center">
		Welcome,
		<%
	// println in broswer, in client machine. not in console
	HttpSession ses = request.getSession();
	out.println(ses.getAttribute("cusUserName"));
	/* ses.getAttribute("un") */
	%> update password successful
	</h4>

	<div class="container loginSuccess">
		<div>
			<h3 class="text-white">What would you like to do?</h3>
			<ul>
				<li><button type="button">
						<a href="/bankapp/changePasswordView/changePassword.html">Change Password</a>
					</button></li>
				<li><button type="button">
						<a href="/bankapp/withdrawMoneyView/withdrawMoney.html">Withdraw Money</a>
					</button></li>
				<li><button type="button">
						<a href="/bankapp/applyLoanView/applyLoan.html">Apply for Loan</a>
					</button></li>
				<li><button type="button">
						<a href="/bankapp/viewStatementView/viewStatement.html">View Statement</a>
					</button></li>
				<li><button type="button">
						<a href="/bankapp/CheckBalance">Check Balance</a>
					</button></li>
			</ul>

		</div>
	</div>



</body>
</html>