<%@page import="entidades.Docente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

  	<script type="text/javascript">
    	$(document).ready( function () {
        $('#ListaDocentes').DataTable();
    	} );
    </script>


	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- FONTAWESOME -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

</head>
<body>

	<jsp:include page="Navbar.jsp"></jsp:include>
	<h1 class="display-4 mt-3 ml-5">Listado de Docentes</h1>
	<br>
	<%
		if (request.getAttribute("docenteAgregado") != null) {
	%>
	<div class="alert alert-success">Se agregó un Docente
		correctamente!</div>
	<script type="text/javascript">
		alert('AGREGADO CORRECTAMENTE.');
	</script>
 	<% 
		}
	
		if (request.getAttribute("docenteEliminado") != null) {
			boolean eliminado = (boolean) request.getAttribute("docenteEliminado");
			if (eliminado == true) {
	%>
	<script type="text/javascript">
		alert('ELIMINADO CORRECTAMENTE.');
	</script>
	<%
		}

		}
	
		
	%>
<%-- 
	<%
		boolean eliminado = (boolean)request.getAttribute("docenteEliminado");
		if (eliminado == true) {%>	<div class="alert alert-success">¡Se elimininó el Docente correctamente!</div>	<%}%>
--%>
	<%

		List<Docente> lista = new ArrayList<Docente>();

		if (request.getAttribute("listaDocentes") != null) {
		lista = (List<Docente>) request.getAttribute("listaDocentes");
		}
	%>

<form class = "w-100 justify-content-center pl-3 pr-3" action="servletListarDocente" method="post">
	<table id="ListaDocentes" class="display">
    	<thead>
        	<tr>

	            <th>Dni</th>
	            <th>Legajo</th>
	            <th>Nombre</th>
	            <th>Apellido</th>
	            <th>E-mail</th>
	            <th>Telï¿½fono</th>
	            <th></th>
				<th></th>



	        </tr>
    	</thead>
    	<tbody>

    			<% if(lista != null) for (Docente docente : lista) { %>

            <tr>

	           		<td><%=docente.getDni() %></td>
		            <td><%=docente.getLegajo() %></td>
		            <td><%=docente.getNombre() %></td>
		            <td><%=docente.getApellido() %></td>
		            <td><%=docente.getEmail() %></td>
		            <td><%=docente.getTelefono() %></td>
	            	<td><a class="btn btn-warning" href="servletListarDocente?dni=<%=docente.getDni()%>&btn=modificar"
						name="Modificar">Modificar</a></td>
					<td><a class="btn btn-danger" 	onclick="return confirm('¿Realmente quiere Eliminar este ítem?');" href="servletListarDocente?dni=<%=docente.getDni()%>&btn=eliminar" name="Eliminar">Eliminar</a></td>
					
         	</tr>

        	<% } %>


    	</tbody>
	</table>



</form>


</body>
</html>
