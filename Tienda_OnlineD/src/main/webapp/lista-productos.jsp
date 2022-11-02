<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>lista</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="login.jsp" style="color: white">Tienda
				Online ${applicationScope.tituloTienda}</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp" style="color: white">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="listaProductos"
						style="color: white">Listado de Productos</a></li>
					<c:if test="${sessionScope.usuario.rol == 'admin'}">
						<li class="nav-item"><a class="nav-link"
							href="alta-producto.jsp" style="color: white">Alta de
								Producto</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<h2>Lista de un productos</h2>
	<div class="border border-warning">${requestScope.mensaje}</div>

	<%

	%>
	<div class=row>
		<c:forEach var="producto" items="${requestScope.lista}">

			<div class="col-4">
				<div class="card" style="width: 18rem;">

					<div class="card-body">
						<div class="bg-secondary text-white">
							<h5 class="card-title bg-secondary text-white">${producto.idProducto}-${producto.descripcion}</h5>
						</div>
						<p class="card-text">Stock: ${producto.stock}</p>
						<p>Precio: ${producto.precio}€</p>
						<a href="comprar?idProducto=${producto.idProducto}">Comprar 1
							unidad</a>
						<c:if test="${sessionScope.usuario.rol == 'admin'}">
						<a class="button btn btn-danger"  href="borrar?idProducto=${producto.idProducto}" style="color: white">Eliminar</a>
					</c:if>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>

	<hr>

	<form class="row row-cols-sm-auto" action="comprar" method="get">



		<div class="col-4">
			<label class="" for="producto">Producto</label> <select
				class="form-select" id="producto" name="idProducto">
				<c:forEach var="producto" items="${requestScope.lista}">
					<option value="${producto.idProducto}">${producto.descripcion}</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-4">
			<label class="" for="cantidad">Cantidad:</label> <input type="number"
				class="form-control" id="cantidad" name="cantidad">

		</div>

		<div class="col-4">
			<div></div>
			<button type="submit" class="btn btn-primary">Comprar</button>
		</div>
	</form>







</body>
</html>