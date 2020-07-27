<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add/update account</title>
</head>
<body>

	<form:form action="addemployee" method="post" modelAttribute="employee">
		<form:hidden path="empId" />
	 <spring:message code="label.empName" /> <form:input path="empName" />
		<br />
	<spring:message code="label.password" /> <form:input path="password" />
		<br />
	 <spring:message code="label.email" /> <form:input path="email" />
		<br />
	 <spring:message code="label.address" /> <form:input path="address" />
		<br />
	<spring:message code="label.phoneNo" /> <form:input path="phoneNo" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>
