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
<title>Chapter Members</title>
<link href="<c:url value="/css/chap.css"/>" rel="stylesheet"/>
</head>
<body>
<jsp:include page ="_menu.jsp"></jsp:include> 
<p>Registered Members From This Chapter</p>
	<table>
		<tr>

			<td style="font-weight: bold; font-style:impact; font-size: 2em;">NAME</td>
			<td style="font-weight: bold; font-style:impact; font-size: 2em;">YEAR</td>
			<td style="font-weight: bold; font-style:impact; font-size: 2em;">EMAIL</td>
			<td style="font-weight: bold; font-style:impact; font-size: 2em;">PHONE NUMBER</td>

		</tr>
		<c:forEach var="chapMems" items="${memberList}">
			<tr>
				<td>${chapMems.name}</td>
				<td>${chapMems.intiationYr}</td>
				<td>${chapMems.email}</td>
				<td>${chapMems.phoneNum}</td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>