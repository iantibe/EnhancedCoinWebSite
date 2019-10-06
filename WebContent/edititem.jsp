<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Coin Items</title>
<style>
	body {
		background-color: green;
	}
	
	form {
		margin: auto;
		border-style: solid;
		}
</style>
</head>
<body>

<form action = "editItem" method="post">
Price <input type ="text" name = "price" value=
"${itemToEdit.price}">
Type of Coin <input type = "text" name = "type" value= "${itemToEdit.type}">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save">
</form>

</body>
</html>