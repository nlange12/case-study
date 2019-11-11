<%@page import="com.sun.xml.bind.v2.util.QNameMap.Entry"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<p>${message}</p>
	<form:form id="resFormObj" modelAttribute="resFormObj" method="post"
		action="${pageContext.request.contextPath}/processCredential">
		<table class="middle">
			<tr>

				<td><form:label path="name" />Name:</td>
				<td><form:input path="name" name="name" id="name"
						placeholder="Full Name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>

				<td><form:label path="username" />Username:</td>
				<c:if test="${action == 'update'}"><td><form:input readonly="true" path="username" name="username" id="username"
						placeholder="Username" /></td></c:if>
						<c:if test="${action != 'update'}"><td><form:input path="username" name="username" id="username"
						placeholder="Username" /></td></c:if>
				<td><form:errors path="username" /></td>
			</tr>
			<form:form id="memFormObj" modelAttribute="memFormObj" method="post"
				action="${pageContext.request.contextPath}/processCredential">
				<tr>

					<td><form:label path="email" />Email:</td>
					<td><form:input path="email" name="email" id="email"
							placeholder="Email Address" /></td>
					<td><form:errors path="email" /></td>
				</tr>
				<tr>

					<td><form:label path="intiationYr" />Initition Year:</td>
					<td><form:input path="intiationYr" name="intiationYr"
							id="intiationYr" placeholder="Semester/Year" /></td>
					<td><form:errors path="intiationYr" /></td>
				</tr>
				<tr>

					<td><form:label path="phoneNum" />Phone Number:</td>
					<td><form:input name="phoneNum" id="phoneNum" path="phoneNum"
							placeholder="xxx-xxx-xxxx" /></td>
					<td><form:errors path="phoneNum" /></td>
				</tr>
				<tr>

					<td><form:label path="chapter.name" />Chapter Name:</td>
					<td><form:input name="chapter.name" id="chapter.name"
							path="chapter.name" placeholder="Chapter Name ex. Nu Tau" /></td>
					<td><form:errors path="chapter.name" /></td>
				</tr>
				<tr>

					<td><form:label path="chapter.school" />Chapter School:</td>
					<td><form:input name="chapter.school" id="chapter.school"
							path="chapter.school" placeholder="School Name" /></td>
					<td><form:errors path="chapter.school" /></td>
				</tr>




			</form:form>
			<tr>

				<td><form:label path="password" />Password:</td>
				<td><form:input type="password" name="password" id="password"
						path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>

				<td><label>Confirm Password:</label></td>
				<td><input type="password" name="confpassword" id="password"
					placeholder="Confirm Password" /></td>
				<td><form:errors path="password" /></td>


			</tr>
			<tr>

				<td><form:button value="Save" id="Save">Save</form:button></td>


			</tr>



		</table>
	</form:form>
</body>
</html>
