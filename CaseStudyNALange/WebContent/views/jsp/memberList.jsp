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
	<table class="middle">
		<tr>

			<td>NAME</td>
			<td>EMAIL</td>

		</tr>
		<c:forEach var="chapMems" items="${memList}">
			<tr>
				<td>${chapMems.name}</td>
				<td>${chapMems.email}</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>