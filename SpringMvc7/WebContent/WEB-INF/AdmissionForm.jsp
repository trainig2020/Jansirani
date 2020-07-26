<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<link rel="stylesheet" href="<spring:theme code='styleSheet' />"
		type="text/css" />
	<p>
		<a href="/SpringMvc7/admissionForm.html?siteTheme=green">Green</a> |
	
		<a href="/SpringMvc7/admissionForm.html?siteTheme=red">Red</a>
	</p>
	<a href="/SpringMvc7/admissionForm.html?siteLanguage=en">English</a> |
	<a href="/SpringMvc7/admissionForm.html?siteLanguage=tamil">French</a>

	<h1>${headerMessage}</h1>
	<h1><spring:message code="label.studentAdmissionForm" /></h1>
	<form:errors path="student.*" />
	<form action="/SpringMvc7/submitAdmissionForm.html" method="post">
		<table>
			<tr>
				<td><spring:message code="label.studentName" /></td>
				<td><input type="text" name="studentName" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentHobby" /></td>
				<td><input type="text" name="studentHobby" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentMobile" /></td>
				<td><input type="text" name="studentMobile" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentDOB" /></td>
				<td><input type="text" name="studentDOB" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentSkills" /></td>
				<td><select name="studentSkills" multiple>
						<option value="java core">Java Core</option>
						<option value="Spring MVC">Spring MVC</option>
						<option value="Hibernate">Hibernate</option>
				</select></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><spring:message code="label.address" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.country" /> <input type="text"
					name="address.country" /></td>
				<td><spring:message code="label.city" /> <input type="text"
					name="address.city" /></td>
				<td><spring:message code="label.street" /><input type="text"
					name="address.street" /></td>
				<td><spring:message code="label.pincode" /><input type="text"
					name="address.pincode" /></td>
			</tr>

		</table>
		<input type="submit">
	</form>
</body>
</html>