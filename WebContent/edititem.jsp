<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a Person</title>
</head>
<body>
<form method="post" action="editThisServlet">
	<table>
		<c:forEach items="${requestScope.searchItems}" var="currentitem">
			<tr>
				<td><input type="radio" name="id" value="${currentitem.id}"></td>
				<td>${currentitem.name}</td>
				<td>${currentitem.age}</td>
				<td>${currentitem.gender}</td>
			</tr>
		</c:forEach>	
	</table>
	<input type="submit" value="Edit Item">
</form>

</body>
</html>