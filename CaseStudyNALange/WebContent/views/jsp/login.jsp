<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${message}
	<form action='<spring:url value="/loginAction" />' method="post">
		<table>
			<tr>

				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>

				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><button type="submit">Login</button></td>
			</tr>
		</table>
	</form>
	<a href="register">No Login? Sing up Here</a>

</body>
</html>


