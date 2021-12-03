<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="template/header.jsp"/>

<body>
	<jsp:include page="template/navbar.jsp"/>
	
	<main layout:fragment="contenido">
    <div class="col-12">
        <h2>Ventas</h2>
        <div th:classappend="'alert-' + (${clase != null} ? ${clase} : info)" th:if="${mensaje != null}"
             th:text="${mensaje}"
             class="alert">
        </div>
        <a class="btn btn-success mb-2" th:href="@{/vender/}">Agregar</a>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Total</th>
                    <th>Productos</th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="venta : ${ventas}">
                    <td th:text="${venta.fechaYHora}"></td>
                    <td th:text="${venta.total}"></td>
                    <td>
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Código de barras</th>
                                <th>Cantidad vendida</th>
                                <th>Precio</th>
                                <th>Total</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr th:each="producto : ${venta.productos}">
                                <td th:text="${producto.nombre}"></td>
                                <td th:text="${producto.codigo}"></td>
                                <td th:text="${producto.cantidad}"></td>
                                <td th:text="${producto.precio}"></td>
                                <td th:text="${producto.total}"></td>
                            </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</main>
</body>

</html>

