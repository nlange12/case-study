<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value='/css/home.css'/>" rel="stylesheet">
<style>
body {
	background-color: purple;
	text-align: center;
	color: white;
	font-family: Helvetica;
}

h1 {
	color: gold;
	text-align: center;
	font-family: Verdana;
}

.left {
	text-align: left;
	color: gold;
	font-family: helvetica;
	font-size: 1em;
}

.right {
	text-align: right;
	color: gold;
	font-family: helvetica;
	font-size: 1em;
}

a:link {
	color: gold;
}

a:visited {
	color: gold;
}

.leftcolumn {
	width: 25%;
	float: left;
	padding: 1em;
}

.rightcolumn {
	width: 20%;
	float: right;
	padding: 1em;
}
</style>
</head>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	${message}
	<h1>Welcome ${memberName} !</h1>
	<div class="leftcolumn">
		<h3 class="left">Chapter Details</h3>
		<p class="left">
			Chapter Name:${chapterName} <br> Chapter Host School:
			${chapterSchool} <br> <a
				href="${pageContext.request.contextPath}/members">Chapter
				Members Currently Registered</a>
		</p>
	</div>
	<div class="rightcolumn">
		<h3 class="right">Manage Account</h3>
		<p class="right">
			<a href="${pageContext.request.contextPath}/edit">Edit</a> <a
				href="${pageContext.request.contextPath}/delete/${member.username}">Delete
				Account</a>
		</p>
	</div>
	<img alt="logo" src="<c:url value= '/images/founders.gif'/>" />
</body>
</html>
