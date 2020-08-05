<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Login Page</h3>

	<form method="post" action="usercheck">

		<c:remove var="message" scope="session" />
		<div class="container">
			<label><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="userName" required> <br>

			<label><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required> <br>

			<button type="submit">Login</button>


		</div>


	</form>

</body>
</html>