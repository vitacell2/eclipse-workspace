<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<title>Listado Clientes</title>
</head>
<body>

	<h1>Listado de Clientes</h1>
	<table class="table">
	<thead>
    <tr>
      <th scope="col">First</th>
      <th scope="col">Last</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach var="cliente" items="${requestScope.lista}">
		<tr>
			<td>${cliente.firstName }</td>
			<td>${cliente.lastName }</td>
			<td><a type="button" href="">Ver Cuentas</a></td>
		</tr>

	</c:forEach>
	</tbody>

  
</table>
<hr>
	<button type="button">Cargar Clientes</button>


</body>
</html>