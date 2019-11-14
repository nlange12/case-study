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
<title>All Chapters</title>
<style>
table{
width:70%; 
margin-left:15%; 
 margin-right:15%;
}
body{
background-color: purple;
  text-align: center;
  color: gold;
  font-family:Helvetica;
  font-weight: bold;
}
a:link{
color:gold;
}
a:visited{
color: gold;
}
</style>
</head>
<body>
<jsp:include page ="_menu.jsp"></jsp:include> 
<p>List of All Chapters</p>
	<table>
		<tr>

			<td style="font-weight: bold; font-style:impact; font-size: 2em;">Name</td>
			<td style="font-weight: bold; font-style:impact; font-size:2em;">School</td>

		</tr>
		<c:forEach var="chap" items="${chapList}">
			<tr>
				<td><a href= "${pageContext.request.contextPath}/chaptermembers/${chap.id}">${chap.name}</a></td>
				<td>${chap.school}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>