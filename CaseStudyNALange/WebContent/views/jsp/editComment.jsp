<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="com.sun.xml.bind.v2.util.QNameMap.Entry"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.table{
width:70%; 
margin-left:15%; 
 margin-right:15%;
}
body{
background-color: purple;
  text-align: center;
  color: white;
  font-family:Helvetica;
}
a:link{
color:gold;
}
a:visited{
color: gold;
}
.border{
border:solid;
border-color:gold;
margin: 10px;
padding: 10px;
color: purple;
background-color: gold;
font-weight:bold;
}
</style>
</head>
<body>
<jsp:include page ="_menu.jsp"></jsp:include> 
<div>&nbsp;</div> 
<div>&nbsp;</div> 
<div>&nbsp;</div> 
<div>&nbsp;</div> 
<div>&nbsp;</div> 
<div>&nbsp;</div> 
<div>&nbsp;</div> 
<div>&nbsp;</div> 
<div>&nbsp;</div> 
	<p class="border">
		<span style="font-weight: bold; font-style:impact; font-size:2em;">${event.title}</span><br> Hosted by:
		${event.getMember().getChapName()}<br> Date: ${event.date}<br>
		<br> ${event.content}
	</p>
	<form:form modelAttribute="commentObj"
		action="${pageContext.request.contextPath}/events/editcomment/${commentObj.id}/processEdit"
		method="post">
		<textarea  style="border:solid;
border-color:gold;"name="content" id="content" placeholder="Leave Comment"
			rows="2" cols="30"></textarea><br>
		<input type="submit" value="Leave Comment" />
	</form:form>

</body>
</html>