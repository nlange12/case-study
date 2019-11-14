<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="<c:url value="/css/chap.css"/>" rel="stylesheet"/>

</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	${message}
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div>&nbsp;</div>
	<div class="table2">
		<form action='<spring:url value="/loginAction" />' method="post">
			<table>
				<tr>

					<td style="color: gold; font-weight: bold;">Username</td>
					<td><input class="form-control" type="text" name="username" /></td>
				</tr>
				<tr>

					<td style="color: gold; font-weight: bold;">Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><button type="submit">Login</button></td>
				</tr>
			</table>
		</form>
		<a href="register">No Login? Sing up Here</a>
		<div>&nbsp;</div>
		<div>&nbsp;</div>
		<img alt="sheild" src="<c:url value= '/images/sheild.png'/>" />

	</div>
</body>
</html>


