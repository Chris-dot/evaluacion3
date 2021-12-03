<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h1>Usuarios</h1>
			<hr>
	<h2>Crear usuarios</h2>
	
		<form:form method="post" action="/usuario/login" modelAttribute="usuario">
			<input type="hidden" name="_method" value="put">
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre:</form:label>
			<form:input type="text" path="nombre" class="form-control"/>
			<br>
			<form:label path="apellido" class="col-sm-2 col-form-label">Apellido:</form:label>
			<form:input type="text" path="apellido" class="form-control"/>
			<br>
			<form:label path="limite" class="col-sm-2 col-form-label">Limite:</form:label>
			<form:input type="text" path="limite" class="form-control"/>
			<br>
			<form:label path="codigoPostal" class="col-sm-2 col-form-label">Código Postal:</form:label>
			<form:input type="text" path="codigoPostal" class="form-control"/>
			<br>
			<form:select class="form-select" path="proyecto">
				<c:forEach var="proyecto" items="${listaProyectos}">
					<form:option value="${proyecto.getId()}">${proyecto.getNombre()}</form:option>
				</c:forEach>
			</form:select>
			<br>			
			<a href="/usuario" class="btn btn-success" role="button" data-bs-toggle="button">Limpiar</a>
			<input type="submit" class="btn btn-primary" value="Submit">

		</form:form>
	
		<br>
		<hr>
		<h2>Lista de usuarios</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Apellido</th>
		      <th scope="col">Limite</th>
		      <th scope="col">Código Postal</th>
		      <th scope="col">Proyecto</th>
		      <th scope="col-2">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listaUsuarios}" var="usuario" >
			    <tr>
			      <th scope="row">${usuario.getId()}</th>
			      <td>${usuario.getNombre()}</td>
			      <td>${usuario.getApellido()}</td>
			      <td>${usuario.getLimite()}</td>
			      <td>${usuario.getCodigoPostal()}</td>
			      <td>${usuario.getProyecto().getNombre()}</td>
			      <td>
			      <a href="/usuario/${usuario.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
			      
			      </td>
			      <td>
				      <form action="/usuario/eliminar" method="get">
				      	<input type="hidden" name="id" value="${usuario.getId()}">
				      	<input class="btn btn-danger" type="submit" value="Eliminar">
				      </form>
			      </td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>