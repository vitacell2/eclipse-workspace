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
body {
  background-color: grey;
  color: white;
}
h2 {color: white; text-align: center;}
p {text-align: center;}
div {text-align: center; margin: top;}
</style>
</head>



<body style="background-color:darkblue;">



<div class="container">

<h2>Bank</h2>

<div> 
	cliente: ${sessionScope.cliente.nombre }
</div>

</div>



</body>

</html>
