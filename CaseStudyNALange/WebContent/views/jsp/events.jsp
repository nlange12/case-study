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
	<br>
	<a href="${pageContext.request.contextPath}/events/createnew">Create
		New Event</a>
	<c:forEach var="events" items="${eventList}">
		<p>
			Event Name :${events.title}<br> Hosted by:
			${events.getMember().getChapName()}<br> Posted:
			${events.timestamp}<br> Description:<br> ${events.content}
		</p>
		<a
			href="${pageContext.request.contextPath}/events/${events.id}/comments">Leave
			Comment</a>
		<c:if test="${events.getMember().getId() == member.getId()}">
			<a href="${pageContext.request.contextPath}/events/${events.id}/edit">Edit</a>
		</c:if>
		<c:if test="${events.getMember().getId() == member.getId()}">
			<a
				href="${pageContext.request.contextPath}/events/${events.id}/delete">Delete</a>
		</c:if>
		<c:if test="${events.getComments().size() > 0 }">
			<p>${events.getComments().size()}comments</p>
		</c:if>



	</c:forEach>
</body>
</html>