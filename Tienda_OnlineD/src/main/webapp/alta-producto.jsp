<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Alta</title>
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

	<h2>Alta de un producto Nuevo</h2>
	<div>usuario: ${sessionScope.usuario.nombre }</div>


	<form action="altaProducto" method="post">
		<div class="mb-3">
			<label for="descripcion" class="form-label">Nombre Producto</label> <input
				type="text" class="form-control" name="descripcion"
				placeholder="Producto">
		</div>
		<div class="mb-3">
			<label for="precioUnidad" class="form-label">Precio Producto</label>
			<input type="number" steo="0.01" class="form-control"
				name="precioUnidad" placeholder="Precio">
		</div>

		<button type="submit" class="btn btn-primary">Insertar</button>


	</form>

	<div class="border border-warning">
		<!--  
<%@ page isELIgnored="false" %>   
-->
		${requestScope.errorBego}

	</div>




</body>
</html>