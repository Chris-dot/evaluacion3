<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="template/header.jsp"/>

<body>
	<jsp:include page="template/navbar.jsp"/>
	
	<main layout:fragment="contenido">
    <div class="col-12">
        <h2>Vender</h2>
        <div th:classappend="'alert-' + (${clase != null} ? ${clase} : info)" th:if="${mensaje != null}"
             th:text="${mensaje}"
             class="alert">
        </div>
        <form th:object="${producto}" th:action="@{/vender/agregar}" method="post">
            <div class="form-group">
                <label for="codigo">C�digo de barras</label>
                <input autofocus autocomplete="off" th:field="*{codigo}" id="codigo"
                       placeholder="Escanea el c�digo o escr�belo y presiona Enter"
                       type="text"
                       class="form-control" th:classappend="${#fields.hasErrors('codigo')} ? 'is-invalid' : ''">
                <div class="invalid-feedback" th:errors="*{codigo}"></div>

            </div>
        </form>
        <form class="mb-2" th:action="@{/vender/terminar}" method="post">
            <button type="submit" class="btn btn-success">Terminar&nbsp;<i class="fa fa-check"></i>
            </button>
            <a th:href="@{/vender/limpiar}" class="btn btn-danger">Cancelar venta&nbsp;<i
                    class="fa fa-trash"></i>
            </a>
        </form>
        <h1 th:text="${'Total: ' + total}"></h1>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>C�digo</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Total</th>
                    <th>Quitar de lista</th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="producto, iterador : ${session.carrito}">
                    <td th:text="${producto.nombre}"></td>
                    <td th:text="${producto.codigo}"></td>
                    <td th:text="${producto.precio}"></td>
                    <td th:text="${producto.cantidad}"></td>
                    <td th:text="${producto.total}"></td>
                    <td>
                        <form th:action="@{/vender/quitar/} + ${iterador.index}" method="post">
                            <button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i>
                            </button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</main>
	
</body>

</html>