<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
			<td>${currentitem.name}</td>
			<td>${currentitem.age}</td>
			<td>${currentitem.gender}</td>
		</tr>
		</c:forEach>
	</table><br/>
	<a href="index.jsp">Return to Menu</a>
</body>
</html>