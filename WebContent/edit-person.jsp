<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Person</title>
</head>
<body>
	<form method="post" action="editPersonServlet">
		<p>Name: </p>
		<input type ="text" name = "name" value="${itemToEdit.name}"><br/>
		<p>Age: </p>
		<input type ="text" name = "age" value="${itemToEdit.age}"><br/>
		<p>Gender: </p>
		<input type ="text" name = "gender" value="${itemToEdit.gender}"><br/>
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>