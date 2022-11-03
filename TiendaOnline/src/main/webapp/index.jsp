<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

	<style>

*
{
	margin: 1% auto;
	padding: 14px;
	color: white;
	text-align: center;
}

h1{
  text-decoration: underline overline;
}

input, select, textarea{
    color: darkgrey;
    background-color: grey;
}

textarea:focus, input:focus, select:focus {
    color: black;
    background-color: darkgrey;
}

input:placeholder{
	color: cyan;
	background-color: red;
}

.div {
  margin: auto;
  width: 50%;
  border: 3px inset darkslateblue;
  padding: 10px;
  text-align: center;
}

.div-user {
  margin: auto;
  width: 100%;
  padding: 0px;
  text-align: center;
  text-decoration: underline;
}

.div-user-text {
  margin: auto;
  width: 40%;
  border: 1px solid blue;
  padding: 10px;
  text-align: center;
}

body {
  background-color: darkblue;
  color: red;
  border: 1px solid blue;
  margin: 5% auto;
  font-size: 20px;
  padding: 20px;
}

h1 {color: yellow; text-align: center; font-family: serif;}
p {text-align: center;}

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
  background-color: red;
  color: black;
  
}

</style>

    <title>index</title>
  </head>
  <body>
  <div class="div">
    <h1>Tienda Online  ${applicationScope.tituloTienda}</h1>
    
    <div class="div-user-text"> <div class="div-user">Usuario actual:</div>${sessionScope.usuario.nombre}</div>
    <br>
    <div class="div-user-text"> <div class="div-user">Tipo de login:</div>${sessionScope.usuario.rol}</div>
    
    <br>
    
    <c:if  test="${sessionScope.usuario.rol == 'administrador'}" > 
   		 <a class="button" href="alta-producto.jsp" role="button">Alta Producto DAO</a>
   		 <a class="button" href="alta-producto-JPA.jsp" role="button">Alta Producto DAO con JPA</a>
   		 <a class="button" href="alta-producto-JPA.jsp" role="button">Modificar un producto con JPA</a>
   		 <a class="button" href="borrarProducto" role="button">Borrar un producto con JPA</a>
    </c:if>
    <a class="button" href="listaProductos" role="button">Lista Productos con DAO</a>
    <a class="button" href="listaProductos" role="button">Lista Productos con JPA</a>
    
    
 </div>

  </body>
</html>