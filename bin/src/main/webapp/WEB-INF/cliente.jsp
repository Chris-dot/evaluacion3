<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
</head>

<body>
	<div class="container">
		<c:if test="${error == 'si'}">
			<p> <c:out value="${mensaje}"/></p>
		</c:if>
		<% String req = request.getParameter("name"); %>
		<% String mensaje = session.getAttribute("mensaje").toString();%>

		<p>nombre: <c:out value="${nombre}"/></p>
		<p>apellido: <c:out value="${apellido}"/></p>
	</div>
</body>

</html>