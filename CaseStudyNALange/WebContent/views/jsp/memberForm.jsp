<%@page import="com.sun.xml.bind.v2.util.QNameMap.Entry"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${message}</p>
	<form:form id="memForm" modelAttribute="memFormObj" method="post"
		action="${pageContext.request.contextPath}/processMember">
		<table class="middle">
			<tr>

				<td><form:label path="name" />Re-enter Your Full Name:</td>
				<td><form:input path="name" name="name" id="name"
						placeholder="Full Name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>

				<td><form:label path="username" />Re-Enter Your Username:</td>
				<td><form:input path="username" name="username" id="username"
						placeholder="Username" /></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>

				<td><form:label path="email" />Email:</td>
				<td><form:input path="email" name="email" id="email"
						placeholder="Email Address" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>

				<td><form:label path="intiationYr" />Initition Year:</td>
				<td><form:input path="intiationYr" name="intiationYr"
						id="intiationYr" placeholder="Semester/Year" /></td>
				<td><form:errors path="intiationYr" /></td>
			</tr>
			<tr>

				<td><form:label path="phoneNum" />Phone Number:</td>
				<td><form:input name="phoneNum" id="phoneNum" path="phoneNum"
						placeholder="xxx-xxx-xxxx" /></td>
				<td><form:errors path="phoneNum" /></td>
			</tr>

			<tr>

				<td><form:button value="save" id="save">Save</form:button></td>


			</tr>



		</table>
	</form:form>
</body>
</html>