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
        $('#ListaAlumnos').DataTable();
    	} );
    </script>
    
	  
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- FONTAWESOME -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="Navbar.html"></jsp:include>
	<h1 class="display-4 mt-3 ml-5">Listado de Alumnos</h1>
	<br>	
	
<form class = "w-100 justify-content-center pl-3 pr-3"  method="post" action="ModificarAlumno.jsp">
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
	            <th></th>
	            <th></th>
	            
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
	            <td><input type="submit" name="btnModificar1" value="Modificar"></input></td>
	            <td><input type="submit" name="btnEliminar1" value="Eliminar"></input></td>
	            
            
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
	             <td><input type="submit" name="btnModificar2" value="Modificar"></input></td>
	            <td><input type="submit" name="btnEliminar2" value="Eliminar"></input></td>
            
        	</tr>
            
        
    	</tbody>
	</table>
</form>

</body>
</html>