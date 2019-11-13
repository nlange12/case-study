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
body{
background-color: purple;
  text-align: center;
  color: gold;
  font-family:Helvetica;
  font-weight:bold;
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
a:link{
color:gold;
}
a:visited{
color: gold;
}
.leftcolumn{
width:20%;
float:left;
padding :1em;
}
.ctrcolumn{
width:60%;
float:left
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

	<p class= "border">
		<span style="font-weight: bold; font-style:impact; font-size:2em;">${event.title}</span><br> Hosted by:
		${event.getMember().getChapName()}<br> Date: ${event.date}<br>
		<br> ${event.content}
	</p>
	<form:form modelAttribute="commentObj"
		action="${pageContext.request.contextPath}/events/${event.id}/comment"
		method="post">
		<textarea name="content" id="content" placeholder="Leave Comment"
			rows="2" cols="30"></textarea><br>
		<input type="submit" value="Leave Comment" />
	</form:form>
	<form:form action = "${pageContext.request.contextPath}/events/${event.id}/rsvp" modelAttribute="rsvp" method = "post"><button>RSVP</button></form:form>
<%-- <form:form action = "${pageContext.request.contextPath}/events/${event.id}/unrsvp"  method = "post"><button>Un-RSVP</button></form:form>--%>
	<div class= "ctrcolumn">
	<p>Comments</p>
	<c:forEach var="comment" items="${event.getComments()}">
		<p>${comment.getMember().getUsername()}<br>
			${comment.content}
		</p>
		<c:if test="${comment.getMember().getId() == member.getId()}">
			<a
				href="${pageContext.request.contextPath}/events/editcomment/${comment.id}">Edit</a>
		</c:if>
		<c:if test="${comment.getMember().getId() == member.getId()}">
			<a
				href="${pageContext.request.contextPath}/events/deletecomment/${comment.id}">Delete</a>
		</c:if>
	</c:forEach>
	</div>
</body>
</html>