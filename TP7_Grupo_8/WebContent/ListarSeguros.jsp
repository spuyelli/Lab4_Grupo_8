<%@page import="servlets.servletSeguro"%>
<%@page import="entidades.Seguro"%>
<%@page import="daoImpl.SeguroDaoImpl"%>
<%@page import="entidades.TipoSeguro"%>
<%@page import="daoImpl.TipoSeguroDaoImpl"%>
<%@page import="java.util.ArrayList"%>
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
	
	<%
		ArrayList<TipoSeguro> listaTiposSeguros = new ArrayList<TipoSeguro>();
		TipoSeguroDaoImpl tsdi = new TipoSeguroDaoImpl();
		listaTiposSeguros = (ArrayList<TipoSeguro>) tsdi.readAll();

		ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
		SeguroDaoImpl sdi = new SeguroDaoImpl();
		listaSeguros = (ArrayList<Seguro>) sdi.readAll();
	%>
	
	<br>
	<br>
	<h2>Tipo de seguros de la base de datos"</h2>
	Busqueda por tipo de seguros :
	
	<form name="formulario" action="servletSeguro" method="post">
		<select name="TiposSeguros_listar" id="SelectTiposSeguros">
			<option value="0">Todos</option>
			<%
				for (TipoSeguro ts : listaTiposSeguros) {
			%>
			<option value=" <%=ts.getId()%> "> <%=ts.getDescripcion()%></option>
			<%
				}
			%>
		</select> <input type="submit" name="btnListar" value="Listar seguros">
	</form>
	
	

<% 
	if(request.getAttribute("listaSeguros")!=null)
	{
		listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaSeguros");
	}

 %>

<table class="display" border="1">
		<thead>
			<tr>
				<th>ID Seguro</th>
				<th>Descripción seguro</th>
				<th>Descripción tipo seguro</th>
				<th>Costo contratación</th>
				<th>Costo máximo asegurado</th>
			</tr>
		</thead>
		
	<%  
	if(listaSeguros!=null)
		for(Seguro seguro : listaSeguros) 
		{ 
		
	%>
	<tr>  
	     <td><%=seguro.getIdSeguro() %> </td>    
	     <td><%=seguro.getDescripcion() %></td>   
	     <td><%=(new TipoSeguroDaoImpl().select(seguro.getTipoSeguro())).getDescripcion()%></td>
	     <td><%=seguro.getCostoContratacion() %></td>   
	     <td><%=seguro.getCostoMaximoAsegurado() %></td>     
	</tr>
	<%  } %>

</table>
</body>
</html>