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
  <div class="container loanApprove">
    <form action="/bankapp/loginView/customerLoginSuccess.jsp">
		<input type="submit" value="Back to Home">
	</form>
  </div>
<div align="center">
	<h1> Your balance:</h1>
	<div  class="container checkbalance">
		<div>
		$<%
		// println in broswer, in client machine. not in console
		HttpSession ses = request.getSession();
		out.println(ses.getAttribute("cusBalance"));
		/* ses.getAttribute("un") */
		%>
	
		</div>
	</div>
	


</div>




</body>
</html>