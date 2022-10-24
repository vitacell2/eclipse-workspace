<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>



<html>
<head>

<style>

*
{
	margin: 1% auto;
	padding: 14px;
}

body {
  background-color: red;
  color: red;
  border: 1px solid #372EFF;
  margin: 1% auto;
  font-size: 20px;
  padding: 1px;
}
h1 {color: yellow; text-align: center; font-family: serif;}
tbody {color: white; text-align: center; font-family: Arial;}
p {color: red; text-align: center;}
div 
	{

	text-align: center; 
	margin: 2% auto;
	}
	
.table
{
	background-color: #1400A0;
	padding: 1px;
}

.tr
{
	background-color: #10009A;
	color: grey;
}

.button {
  border: none;
  font-family: Helvetica;
  background-color: darkred;
  color: lightblue;
  padding: 15px 16px;
  text-align: center;
  text-decoration: underline;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border: 2px solid #A800FF;
}

.button:hover {
  background-color: #00F6FF;
  color: black;
  
}

</style>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


</head>
<title>Listado clientes</title>
<body style="background-color:darkblue;">
	<div style="width: 95%">
	<h1>Listado de Clientes</h1>
	<table class="table">
	<thead>
    <tr class="tr">
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Account</th>
    </tr>
  </thead>
  <tbody style="background-color:blue;">
	<c:forEach var="cliente" items="${requestScope.lista}">
		<tr>
			<td>${cliente.firstName }</td>
			<td>${cliente.lastName }</td>
			<td color="red"><a type="button" href="" style="color:green;">Cuenta</a></td>
		</tr>

	</c:forEach>
	</tbody>
	
  
</table>
<hr>
	<button type="button" class="button">Cargar clientes</button>



                
</div>
</body>
</html>