<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h1>Students Admission Form</h1>
	<form:errors path="student.*"/>
	<form action="/SpringMvc5/submitAdmissionForm.html" method="post">
		<table>
			<tr>
				<td>Student's Name:</td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td>Student's Hobby:</td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td>Student's Mobile:</td>
				<td><input type="text" name="studentMobile" /></td>
			</tr>
			<tr>
				<td>Student's DOB:</td>
				<td><input type="text" name="studentDOB" /></td>
			</tr>
			<tr>
				<td>Student's Skill Set:</td>
				<td><select name="studentSkills" multiple>
						<option value="java core">Java Core</option>
						<option value="Spring MVC">Spring MVC</option>
						<option value="Hibernate">Hibernate</option>
				</select></td>
			</tr>
		</table>
		<table>
		<tr><td>Student's Address </td></tr>
		<tr>
		<td> Country :  <input type="text" name="address.country" /></td>
		<td> City :  <input type="text" name="address.city" /></td>
		<td> Street :  <input type="text" name="address.street" /></td>
		<td> Pin Code :  <input type="text" name="address.pincode" /></td>
		</tr>
		
		</table>
		<input type="submit">
	</form>
</body>
</html>