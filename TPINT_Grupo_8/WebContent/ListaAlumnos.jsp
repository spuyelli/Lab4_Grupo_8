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
        $('#ListaAlumnos').DataTable();
    	} );
    </script>
    
    <style type="text/css">
    	<jsp:include page="Css/StyleSheet.css"></jsp:include>
	</style>

</head>
<body>

	<h2>Listado de Alumnos Correspondiente al Curso ....</h2>
	
		
<form method="post" action="Servlet">
	<table id="ListaAlumnos" class="display">
    	<thead>
        	<tr>
	            <th>Legajo</th>
	            <th>Dni</th>
	            <th>Nombre y Apellido</th>
	            <th>Fecha de Nacimiento</th>
	            <th>Dirección</th>
	            <th>Nacionalidad</th>
	            <th>Provincia</th>
	            <th>E-mail</th>
	            <th>Teléfono</th>
	            
	        </tr>
    	</thead>
    	<tbody>
    
    		<!-- DATOS DE EJEMPLO. ACA REALIZAMOS LA BUSQUEDA SEGUN LO NECESITADO  -->
        	<tr>
	            <td>1</td>
	            <td>30256365</td>
	            <td>Juan Gonzalez</td>
	            <td>14/02/2000</td>
	            <td>El salvador 326</td>
	            <td>Argentina</td>
	            <td>Bs. As.</td>
	            <td>jgonzalez@gmail.com</td>
	            <td>1125365258</td>
            
        	</tr>
        	<tr>
	            <td>2</td>
	            <td>28256365</td>
	            <td>Luis Miguel</td>
	            <td>14/02/1980</td>
	            <td>Miami 256</td>
	            <td>Puerto Rico</td>
	            <td>San Juan</td>
	            <td>lmiguel@gmail.com</td>
	            <td>1165985698</td>
            
        	</tr>
            
        
    	</tbody>
	</table>
</form>

</body>
</html>