<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/bankapp/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Balance</title>
</head>
<body>
  <div>
		<form action="/bankapp/loginView/customerLoginSuccess.jsp">
			<button type="submit" class="btn btn-light" style="float: right">Back
				to home</button>
		</form>
	</div>
<div align="center">
	
	<div class="text-white">
	<h1 class="text-white"> 
	Your balance:
		
		$<%
		// println in broswer, in client machine. not in console
		HttpSession ses = request.getSession();
		out.println(ses.getAttribute("cusBalance"));
		/* ses.getAttribute("un") */
		%>
	</h1>
	
	</div>
	


</div>




</body>
</html>