<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h3>Congratulations ! your application has been processed
		successfully</h3>
	<h2>Details submitted by you:</h2>
	<table>
		<tr>
			<td>Student Name :</td>
			<td>${student.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby :</td>
			<td>${student.studentHobby}</td>
		</tr>
	</table>
</body>
</html>