<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seguros - Listar seguros</title>
</head>
<body>
	<a href="Inicio.jsp"> Inicio </a> &emsp;
	<a href="AgregarSeguro.jsp"> Agregar Seguro </a> &emsp;
	<a href="ListarSeguros.jsp"> Listar Seguros </a>
	
	<br>
	<br>
	<h2>Tipo de seguros de la base de datos"</h2>
	<label for="cars">Busqueda por tipo de seguros :</label>
	
<select name="lblSeguros" id="Seguros">
  <option value="Casas">Seguro de casas</option>
  <option value="Vida">Seguro de vida</option>
  <option value="Motos">Seguro de motos</option>
</select>      <input type="submit" name="BtnListar" value="Listar seguros">
	
	<form method ="" action="">
	
	</form>
</body>
</html>