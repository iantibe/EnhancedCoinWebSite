<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Coin List</title>
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

	<form method = "post" action = "navigationServlet">
		<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
		 <td><input type="radio" name="id" value="${currentitem.id}"></td>
		 <td>${currentitem.price}</td>
		 <td>${currentitem.type}</td>
		 </tr>
		</c:forEach>
		</table>
	<input type = "submit" value = "edit" name="doThis">
	<input type = "submit" value = "delete" name="doThis">
	<input type="submit" value = "add" name = "doThis">
	</form>

</body>
</html>