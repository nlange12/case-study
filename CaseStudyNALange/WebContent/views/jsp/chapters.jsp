<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="com.sun.xml.bind.v2.util.QNameMap.Entry"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	${message}
	<table>
		<tr>

			<td>Name</td>
			<td>School</td>

		</tr>
		<c:forEach var="chap" items="${chapList}">
			<tr>
				<td>${chap.name}</td>
				<td>${chap.school}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="register">Back To Login</a>
</body>
</html>