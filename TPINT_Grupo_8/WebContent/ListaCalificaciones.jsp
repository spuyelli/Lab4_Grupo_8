<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

  	<script type="text/javascript">
    	$(document).ready( function () {
        $('#ListaCalificaciones').DataTable();
    	} );
    </script>
    
    <style type="text/css">
    	<jsp:include page="Css/StyleSheet.css"></jsp:include>
	</style>
</head>
<body>

	
	<h2>Listado de Calificaciones Correspondiente al Alumno .... del curso ...</h2>
	
		
<form method="post" action="Servlet">
	<table id="ListaCalificaciones" class="display">
    	<thead>
        	<tr>
	            <th>Legajo</th>
	            <th>Nombre y Apellido</th>
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
    
    		<!-- DATOS DE EJEMPLO. ACA REALIZAMOS LA BUSQUEDA SEGUN LO NECESITADO  -->
        	<tr>
	            <td>1</td>
	            <td>Juan Gonzalez</td>
	            <td>6</td>
	            <td>8</td>
	            <td>8</td>
	            <td></td>
	            <td>7,33</td>
	            <td>Regular</td>
	            <td>  <input type="checkbox" id="cbox1" > </td>
	            
            
        	</tr>
        	<tr>
	            <td>2</td>
	            <td>Luis Miguel</td>
	            <td>4</td>
	            <td>5</td>
	            <td>10</td>
	            <td>10</td>
	            <td>7,25</td>
	            <td>Regular</td>
	            <td> <input type="checkbox" id="cbox2" > </td>
            
        	</tr>
            
        
    	</tbody>
	</table>
	
	<!-- DATOS DE EJEMPLO.  -->
	<select name="Notas">
	
	<option value="Parcial1">Parcial 1</option>	
	<option value="Parcial2">Parcial 2</option>	
	<option value="Recuperatorio1">Recuperatorio 1</option>	
	<option value="Recuperatorio2">Recuperatorio 2</option>
	
	</select>
	
	<input type="submit" name="btnAplicarSeleccion" value="Aplicar"></input>
	
</form>

</body>
</html>