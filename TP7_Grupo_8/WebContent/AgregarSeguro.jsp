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

	<form method="post" action="servletSeguro">
		<table>
			<tr>
				<th ALIGN="left">IDseguro:
				<th ALIGN="left"><%=seguro.getIdSeguro()%> <input type="hidden" name="lblID" value="<%=seguro.getIdSeguro()%>" required >
			<tr>
				<th ALIGN="left">Descripción:
				<th ALIGN="left"><input type="text" name="txtDescripcion" required oncopy="return false" onpaste="return false"> <br>
			<tr>
				<th ALIGN="left">Tipo de Seguro:
				<th ALIGN="left"><select name="tiposSeguros_agregar" id="selectTipoSeguro" required>
						<%
							for (TipoSeguro ts : alTipoSeguro) {
						%><option value="<%=ts.getId()%>"><%=ts.getDescripcion()%></option>
						<%
							}
						%>
				</select>
			<tr>
				<th ALIGN="left">Costo Contratación:
				<th ALIGN="left"><input type="number" min="0" name="txtContratacion" required oncopy="return false" onpaste="return false"> <br>
			<tr>
				<th ALIGN="left">Costo MáximoAsegurado:
				<th ALIGN="left"><input type="number" min="0" name="txtMaximo" required oncopy="return false" onpaste="return false"> <br><tr>
				<th ALIGN="left">
				<th ALIGN="left"><input type="submit" name="btnAceptar" value="Aceptar">
		</table>



	</form>


</body>
</html>