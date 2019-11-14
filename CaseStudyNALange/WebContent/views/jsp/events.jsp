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
<title>Events</title>
<link href="<c:url value="/css/chap.css"/>" rel="stylesheet"/>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	${message}
	<br>

	<a href="${pageContext.request.contextPath}/events/createnew">Create
		New Event</a>
	<br>
	<div class="leftcolumn">
		<form method="post" action="search">
			<table class="middle">
				<tr>
					<td><input type="date" name="d1" id="d1" class="date" /></td>
				</tr>
				<tr>
					<td><input type="date" name="d2" id="d2" class="date" /></td>

				</tr>
				<tr>

					<td><a href="search"><button name="search" id="search">Search</button></a></td>
				</tr>
				<tr>


					<td><a href="user"><button name="clear" id="clear">Clear</button></a></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="ctrcolumn">
		<c:forEach var="events" items="${eventList}">
			<p class="border">
				<span style="font-weight: bold; font-style: impact; font-size: 2em;">${events.title}</span><br>
				Hosted by: ${events.getMember().getChapName()}<br> Date:
				${events.date}<br> ${events.content}<br>
				<c:if test="${events.getComments().size() > 0 }">
			${events.getComments().size()}comment(s)<br>
				</c:if>
				<c:if test="${events.getRsvp().size() > 0 }">
			${events.getRsvp().size()}rsvp(s)
		</c:if>
			</p>
			<a
				href="${pageContext.request.contextPath}/events/${events.id}/comments">
				Comment/RSVP</a>
			<c:if test="${events.getMember().getId() == member.getId()}">
				<a
					href="${pageContext.request.contextPath}/events/${events.id}/edit">Edit</a>
			</c:if>
			<c:if test="${events.getMember().getId() == member.getId()}">
				<a
					href="${pageContext.request.contextPath}/events/${events.id}/delete">Delete</a>
			</c:if>
</c:forEach>
	</div>
</body>
</html>