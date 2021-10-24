<%@page import="servlets.servletSeguro"%>
<%@page import="entidades.Seguro"%>
<%@page import="java.util.ArrayList"%>
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
	
	<br>
	<br>
	<h2>Tipo de seguros de la base de datos"</h2>
	<label for="cars">Busqueda por tipo de seguros :</label>
	
	<form method ="post" action="servletSeguro">
		<select name="lblSeguros" id="Seguros">
		  <option value="Casas">Seguro de casas</option>
		  <option value="Vida">Seguro de vida</option>
		  <option value="Motos">Seguro de motos</option>
		</select>      
		<input type="submit" name="BtnListar" value="Listar seguros">
	</form>
	
	

<% 
	ArrayList<Seguro> listaSeguros = null;
	if(request.getAttribute("listaS")!=null)
	{
		listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaS");
	}

 %>

<table border="1">
	<tr> <th>ID Seguro</th>  <th>Descripción seguro</th>  <th>Descripción tipo seguro</th>  <th>Costo contratación</th> <th>Costo máximo asegurado</th> </tr>
	
	<%  if(listaSeguros!=null)
		for(Seguro seguro : listaSeguros) 
		{
	%>
	<tr>  
	     <td><%=seguro.getIdSeguro() %> </td>    
	     <td><%=seguro.getDescripcion() %></td>   
	     <td><%=seguro.getTipoSeguro() %></td>   
	     <td><%=seguro.getCostoContratacion() %></td>   
	     <td><%=seguro.getCostoMaximoAsegurado() %></td>     
	</tr>
	<%  } %>

</table>
</body>
</html>