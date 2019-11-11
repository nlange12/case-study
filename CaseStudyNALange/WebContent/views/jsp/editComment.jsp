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
</head>
<body>
	<p>
		Event Name :${event.title}<br> Hosted by:
		${event.getMember().getChapName()}<br> Posted: ${event.timestamp}<br>
		Description:<br> ${event.content}
	</p>
	<form:form modelAttribute="commentObj"
		action="${pageContext.request.contextPath}/events/editcomment/${commentObj.id}/processEdit"
		method="post">
		<textarea name="content" id="content" placeholder="Leave Comment"
			rows="2" cols="30"></textarea>
		<input type="submit" value="Leave Comment" />
	</form:form>

</body>
</html>