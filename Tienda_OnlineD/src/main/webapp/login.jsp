<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="login" method="post">
		<div class="mb-3">
			<label for="nombre" class="form-label">Usuario</label> 
			<input type="text" class="form-control"name="nombre" placeholder="Nombre">
		</div>
		<div class="mb-3">
			<label for="rol" class="form-label">Rol</label> 
			<select class="form-select" aria-label="Default select example" name="rol">
				<option selected>Selecciona el rol...</option>
				<option value="admin">Admin</option>
				<option value="usuario">Usuario</option>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Acceder</button>
	</form>
</body>
</html>