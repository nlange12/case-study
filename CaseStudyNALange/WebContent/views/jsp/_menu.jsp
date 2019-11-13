<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>



<div>
<a href = "${pageContext.request.contextPath}">Home</a>
| &nbsp;&nbsp;
<a href = "${pageContext.request.contextPath}/events">Events</a>
| &nbsp;&nbsp;
<a href = "${pageContext.request.contextPath}/chapters">Chapters</a>
| &nbsp;&nbsp;
<a href = "${pageContext.request.contextPath}/programs">Mandated Programs</a>




<c:if test="${pageContext.request.userPrincipal.name != null}">
| &nbsp;&nbsp;
<a href = "${pageContext.request.contextPath}/logout">Logout</a>


</c:if>


</div>