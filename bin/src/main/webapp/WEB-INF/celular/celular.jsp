<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	    <form:form method="post" action="/celular/crear" modelAttribute="celular">
			<form:label path="numero" class="col-sm-2 col-form-label">Numero:</form:label>
			<form:input type="text" path="numero" class="form-control"/>
			<br>
			<form:label path="marca" class="col-sm-2 col-form-label">Marca:</form:label>
			<form:input type="text" path="marca" class="form-control"/>
			<br>
			<form:select class="form-select" path="usuario">
				<c:forEach items="${listaUsuarios}" var="usuario" >
					<form:option value="${usuario.getId()}">
						${usuario.getNombre()} ${usuario.getApellido()}
			     	</form:option>
				</c:forEach>
			</form:select>
			<br>
			<input type="submit" class="btn btn-primary" value="Crear Celular">

		</form:form>
		<br>
		<!-- lista de los celulares y sus usuario -->
		
		<h2>Listado Celulares</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Numero</th>
		      <th scope="col">Marca</th>
		      <th scope="col">Usuario</th>
		      <th scope="col-2">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listaCelulares}" var="celular" >
			    <tr>
			      <th scope="row">${celular.getId()}</th>
			      <td>${celular.getNumero()}</td>
			      <td>${celular.getMarca()}</td>
			      <td>
			      	${celular.getUsuario().getNombre()} 
			      	${celular.getUsuario().getApellido()}
			      </td>
			     
			      <td>
			      <a href="/celular/${celular.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
			      
			      </td>
			      <td>
				      <form action="/celular/eliminar" method="get">
				      	<input type="hidden" name="id" value="${celular.getId()}">
				      	<input class="btn btn-danger" type="submit" value="Eliminar">
				      </form>
			      </td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
    </div>
</body>

</html>