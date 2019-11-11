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
	Welcome ${memberName} !
	<br> Chapter Details
	<br> Chapter Name:${chapterName}
	<br> Chapter Host School: ${chapterSchool}
	<br>
	<a href="${pageContext.request.contextPath}/members">List of
		Chapter Members</a>
	<a href="${pageContext.request.contextPath}/events">List of All
		Events</a>
		
	<a href="${pageContext.request.contextPath}/edit">Edit</a>
	<a href="${pageContext.request.contextPath}/delete/${member.username}">Delete Account</a>
</body>
</html>
