<%@page import="entidades.Calificacion"%>
<%@page import="negocioImpl.CalificacionNegImpl"%>
<%@page import="entidades.Curso"%>
<%@page import="entidades.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Calificaciones</title>
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
        $('#ListaCalificaciones').DataTable();
    	} );
    </script>
    
    
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- FONTAWESOME -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="Navbar.jsp"></jsp:include>
	
<h1 class="display-4 mt-3 ml-5">Listado de Calificaciones del Curso <label for="" class="form-label"><%= ((Curso)session.getAttribute("Curso")).getMateria().getDescripcion()%> - Semestre <%= ((Curso)session.getAttribute("Curso")).getSemestre() %>, Año <%= ((Curso)session.getAttribute("Curso")).getAño() %></label> </h1>
<br>
	<%
		List<Calificacion> lista =  new ArrayList<Calificacion>();
		
		if (request.getAttribute("ListaCalificaciones") != null) {
			lista = (List<Calificacion>) request.getAttribute("ListaCalificaciones");
		}
	
	%>
	<form class = "w-100 justify-content-center pl-3 pr-3"  method="post" action="servletCalificaciones">

	<table id="ListaCalificaciones" class="display">
    	<thead>
        	<tr>
	            <th>Nombre</th>
	            <th>Apellido</th>
	            <th>Parcial 1</th>
	            <th>Parcial 2</th>
	            <th>Recuperatorio 1</th>
	            <th>Recuperatorio 2</th>
	            <th>Promedio</th>
	            <th>Estado</th>
	            <th></th>
	            
	        </tr>
    	</thead>
    	<tbody>
    
    		<%	if(lista != null ) for (Calificacion cal : lista) {%>
        	<tr>
	            <td><%=cal.getNombre() %></td>
	            <td><%=cal.getApellido() %></td>
	            <td><%=cal.getParcial1() %></td>
	            <td><%=cal.getParcial2() %></td>
	            <td><%=cal.getRecuperatorio1() %></td>
	            <td><%=cal.getRecuperatorio2() %></td>
	            <% float prom = ((cal.getParcial1() + cal.getParcial2() + cal.getRecuperatorio1() + cal.getRecuperatorio2())/4); %>
	            <td><%=prom %></td>
				<td><% if(cal.isestadoAprobacion()) {%> Regular <%} else{ %> Libre <%}%> 
	           	</td>
				<td><input type="checkbox" name="chk" value="<%=cal.getDniAlumno()%>"> </td>
        	</tr>
            <% } %>
        
    	</tbody>
	</table>
	
	<!-- DATOS DE EJEMPLO.  -->
	<select name="Notas">
	
	<option value="Parcial1">Parcial 1</option>	
	<option value="Parcial2">Parcial 2</option>	
	<option value="Recuperatorio1">Recuperatorio 1</option>	
	<option value="Recuperatorio2">Recuperatorio 2</option>
	</select>
	<input type="number" step="0.01" name="nota" max="10" min ="0" placeholder="10.00"></input>
	<input type="submit" name="btnAplicarSeleccion" value="Aplicar"></input>
	
	
</form>

</body>
</html>