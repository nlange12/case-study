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
	<form:form id="event" modelAttribute="eventObj" method="post"
		action="${pageContext.request.contextPath}/events/${eventObj.id}/processEdit">
		<table class="middle">
			<tr>

				<td><form:label path="title" />Event Title:</td>
				<td><form:input path="title" name="title" id="title"
						placeholder="Title"></form:input></td>
			</tr>
			<tr>

				<td><form:label path="content" />Event Description:</td>
				<td><form:textarea path="content" name="content" id="content"
						rows="7" cols="70" placeholder="Describe The Event"></form:textarea></td>
			</tr>
			<tr>
				<td><form:button value="Post" id="post">Post</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>