<%@page import="entidades.Seguro"%>
<%@page import="daoImpl.TipoSeguroDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.TipoSeguro"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seguros - Agregar seguro</title>
</head>
<body>
	<a href="Inicio.jsp"> Inicio </a> &emsp;
	<a href="AgregarSeguro.jsp"> Agregar Seguro </a> &emsp;
	<a href="ListarSeguros.jsp"> Listar Seguros </a>

	<h1>Agregar Seguro</h1>

<%
	Seguro seguro = new Seguro();
	ArrayList<TipoSeguro> alTipoSeguro = new ArrayList<TipoSeguro>();
	TipoSeguroDaoImpl tsdi = new TipoSeguroDaoImpl();
	alTipoSeguro = (ArrayList<TipoSeguro>) tsdi.readAll();
%>

	<form action="Inicio.jsp" method="get">
		IDseguro:
		<%=seguro.getIdSeguro()%>
		<br>
		Descripción: <input type="text" name="txtDescripcion"> <br>
		Tipo de Seguro: 
		<select name="tiposSeguros" id="selectTipoSeguro">
		<%
			for(TipoSeguro ts:alTipoSeguro){
				%><option value="<%=ts.getId() %>"><%=ts.getDescripcion()%></option> <%
			}
		 %>
		</select>
		
		<br> 
		Costo Contratación: <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 44' name="txtContratacion"> <br>
		Costo MáximoAsegurado: <input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 44' name="txtMaximo"> <br>
		<input type="submit" name="btnAceptar" value="Aceptar">
	</form>


</body>
</html>