<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html lang="es">

<head>

<!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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
  margin: 5% auto;
  font-size: 20px;
  padding: 7px;
}
h2 {color: yellow; text-align: center; font-family: serif;}
p {text-align: center;}
div {text-align: center;}

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
</head>



<body style="background-color:darkblue;">





<div> 
<h2>Bank</h2>


	<!--  cliente: ${sessionScope.cliente.nombre } -->
	<a class="button" color="red" href="listaClientes" role="button">Listar clientes</a>
</div>





</body>

</html>
