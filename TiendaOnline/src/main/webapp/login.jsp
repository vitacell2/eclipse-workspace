<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>

*
{
	margin: 1% auto;
	padding: 14px;
	color: white;
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

.div-login-text {
  margin: auto;
  width: 50%;
  border: 1px solid blue;
  padding: 4px;
  text-align: center;
}

body {
  background-color: red;
  color: red;
  border: 1px solid blue;
  margin: 5% auto;
  font-size: 20px;
  padding: 7px;
}
h4 {color: yellow; text-align: center; font-family: serif;}
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

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Login</title>
</head>
<body style="background-color:darkblue;">
<div class="div">

	<h1>Tienda Online</h1>
	 
	<div class="div-login-text">
	<h4>Login</h4>
	</div>



	<form action="login" method="post">


		<label for="nombreUsr">Nombre Usuario</label> 
		<input type="text"
			id="nombreUsr" name="nombre" /> 
			
		<br>
	   <label for="rolUsr">Rol</label> 
	   <select
			id="rolUsr" name="rol">
			<option value="administrador">administrador</option>
			<option value="cliente" selected>cliente</option>
		</select>

        <br>
        <button type="submit" class="button">Enviar</button>
	</form>
</div>

</body>
</html>