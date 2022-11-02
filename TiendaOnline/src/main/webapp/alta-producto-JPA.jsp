<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Alta</title>
    
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
    
  </head>
<body>

<div class="div">
<h1>Tienda Online ${applicationScope.tituloTienda}</h1>
<h4>Alta de un producto nuevo con JPA</h4>
<div class="div-user-text"> <div class="div-user">Usuario actual:</div>${sessionScope.usuario.nombre}</div>


<form action="altaProductoJPA" method="post">

	<div class="div">
   <div class="div-user">Nombre Producto:</div><input type="text" name="descripcion" value="" />
   
   <br>
   <br>
   <div class="div-user">Precio Producto:</div><input type="text" name="precioUnidad" value="1.0" />
   
   <br>
   <button type="submit" class="button">Grabar con JPA</button>
 	</div>
 

</form>

<div class="border border-warning"> 
   ${requestScope.errorBego}  
</div>



</div>
</body>
</html>