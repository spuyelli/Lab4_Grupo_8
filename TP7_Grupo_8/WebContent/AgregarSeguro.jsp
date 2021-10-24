<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="Inicio.jsp"> Inicio </a> &emsp;
	<a href="AgregarSeguro.jsp"> Agregar Seguro </a> &emsp;
	<a href="servletSeguro?Completo=0"> Listar Seguros </a>

	<h1>Agregar Seguro</h1>

	<form action="Inicio.jsp" method="get">
		IDseguro: <br> 
		Descripción: <input type="text" name="txtNombre"> <br> 
		Tipo de Seguro: <br> 
		Costo Contratación: <input type="text" name="txtApellido"> <br> 
		Costo MáximoAsegurado: <input type="text" name="txtApellido"> <br> 
		<input type="submit" name="btnAceptar" value="Aceptar">
	</form>


</body>
</html>