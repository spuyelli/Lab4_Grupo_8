<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="Inicio.jsp"> Inicio </a> 
	<a href="AgregarSeguro.jsp"> Agregar Seguro </a> 
	<a href="ListarSeguros.jsp"> Listar Seguros </a>

<h1>Agregar Seguro</h1>
	
	<form action="Ejemplo5.jsp" method="get">
	IDseguro: <br>
	
	Descripci�n: <input type="text" name="txtNombre"> <br>
	<br>
	Tipo de Seguro: <br>
	Costo Contrataci�n: <input type="text" name="txtApellido"> <br>
	Costo M�ximo Asegurado: <input type="text" name="txtApellido"> <br>
	<input type="submit" name="btnAceptar" value="Aceptar">
</form>
	

</body>
</html>