<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page='../template/header.jsp'/>

<body>
	<jsp:include page='../template/navbar.jsp'/>
	<div class="container">
	<h1>Proyectos</h1>
			<hr>
	<h2>Crear Proyecto</h2>
	
		<form:form method="post" action="/proyecto/crear" modelAttribute="proyecto">
			<form:label path="nombre" class="col-sm-2 col-form-label">Nombre:</form:label>
			<form:input type="text" path="nombre" class="form-control"/>
			<br>
			<form:label path="descripcion" class="col-sm-2 col-form-label">Descripcion:</form:label>
			<form:input type="text" path="descripcion" class="form-control"/>
			<br>
			<input type="submit" class="btn btn-primary" value="Crear Proyecto">

		</form:form>
	
		<br>
		<hr>
		<h2>Lista de Proyectos</h2>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Descripcion</th>
		      <th scope="col-2">Acciones</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${listaProyectos}" var="proyecto" >
			    <tr>
			      <th scope="row">${proyecto.getId()}</th>
			      <td>${proyecto.getNombre()}</td>
			      <td>${proyecto.getDescripcion()}</td>
			      <td>
			      <a href="/proyecto/${proyecto.getId()}/editar" class="btn btn-primary" role="button" data-bs-toggle="button">Editar</a>
			      
			      </td>
			      <td>
				      <form action="/proyecto/eliminar" method="get">
				      	<input type="hidden" name="id" value="${proyecto.getId()}">
				      	<input class="btn btn-danger" type="submit" value="Eliminar">
				      </form>
			      </td>
			    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		<br>
		<hr>
	 <h2> Lista desde Join</h2>
	 
	 <table>
		 <thead>
		 <tr>
		 	<th>Nombre Proyecto</th>
		 	<th>Nombre Usuario</th>
		 </tr>
		 </thead>
		 <tbody>
		 	<c:forEach var="fila" items="${proyectoUsuarios}">
			 	<tr>
			 		<td>${fila[0].getNombre()}</td>
			 		<td>${fila[1].nombre}</td>
			 	</tr>
		 	</c:forEach>
		 </tbody>
	 </table>
	</div>
	<jsp:include page='../template/footer.jsp'/>
</body>

</html>