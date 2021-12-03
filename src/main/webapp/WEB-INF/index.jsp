<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='template/header.jsp'/>

<link rel="stylesheet" href="css/estilo.css">
 <link href="/css/font-awesome.min.css" rel="stylesheet">
<style>
	body{
		background-color: black;
	}
	h2{
		margin-top: 325px;
		color: #ffffff;
		text-align: left;
		width: 550px;
		height: 1	50px;
	}
	.container{
		box-sizing: border-box;
	}
	
	button{
		text-align: left;
		
	}
</style>
<body>

<div class="container"  >

<h2>Bienvenido a la aplicacion de venta con Spring</h2>
<form action="/registro">
        <button class="btn btn-primary mt-4" type="submit">Registrar</button>
 </form>
 

 
 <form action="/login">
        <button class="btn btn-primary mt-4" type="submit">Ingresar</button>
 </form>
 <!--
 	<ul>
	 	<li><a href="/registro" style="text-decoration: none">Registrate!</a></li>
	 	<li><a href="/login" style="text-decoration: none">Ingresa</a></li>
	 </ul>
	  --> 
	 
</div>
<jsp:include page='template/footer.jsp'/>
</body>
</html>