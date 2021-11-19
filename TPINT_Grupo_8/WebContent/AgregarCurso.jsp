<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- FONTAWESOME -->
	<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>
	
	<script type="text/javascript">
    	$(document).ready( function () {
        $('#ListaAlumnosXCursos').DataTable();
    	} );
    </script>
    
<title>Agregar Curso</title>
</head>
<body>
	<jsp:include page="Navbar.html"></jsp:include>
	<div class="d-flex justify-content-center">
		<h1 class="display-4 mt-5 ml-5">Agregar Curso</h1>
	</div>
	<br>
	<div class="conteiner d-flex justify-content-center">
		<form class="card p-3 bg-light  h-100 w-75 justify-content-center" style="height: 350px;" method="post" action="servlet.java">

			<div class="row mb-4 justify-content-center">
				<div class="col-3 ml-4">
					<div class="form-outline">
						<label for="">Nombre de la Carrera: </label>
						<select class="form-control" name="inputNombreCarrera" id="inputNombreCarrera" required>
							<option value="value1">Técnico Superior en Programación</option>
						</select>
					</div>
				</div>
				<div class="col-3 ml-4">
					<div class="form-outline">
						<label for="">Nombre de la Materia: </label>
						<input type="text" class="form-control" id="inputNombreMateria" required>
					</div>
				</div>
			</div>

			<div class="row mb-4 justify-content-center">
				<div class="col-3 ml-4">
					<div class="row justify-content-center">
						<div class="col">
							<label for="">Año: </label>
							<input type="number" class="form-control" id="inputAnio">
						</div>
						<div class="col" style="text-align: center;">
							<label for="">Semestre: </label>
							<br>
							<input type="radio" name="inputSemestre" value=1> 1
							<input type="radio" name="inputSemestre" value=2> 2
						</div>
					</div>
				</div>
				<div class="col-3 ml-4">
					<label for="">Nombre del Docente: </label>
					<select type="text" class="form-control" id="inputDocente" required placeholder="Perez">
						<option value="value1">Herrera, Tamara</option>
						<option value="value2">Casa, Pepe</option>
					</select>
				</div>
			</div>

			<!-- Search form -->
		        <input class="form-control me-2 w-25 mb-2" type="search" placeholder="Buscar alumno" aria-label="Search">			
			<table id="ListaAlumnosXCursos" class="table" >
		    	<thead>
		        	<tr>
			            <th>Legajo</th>
			            <th>Nombre y Apellido</th>
			            <th>DNI</th>
			            <th>Selección</th>
			        </tr>
		    	</thead>
		    	<tbody>
		    
		    		<!-- DATOS DE EJEMPLO. ACA REALIZAMOS LA BUSQUEDA SEGUN LO NECESITADO  -->
		        	<tr>
						<td>1</td>
			            <td>Juan Gonzalez</td>
			            <td>30256365</td>
			            <td>  <input type="checkbox" id="cbox1" > </td>
		        	</tr>
		        	
		        	<tr>
			            <td>2</td>
			            <td>Luis Miguel</td>
			            <td>28256365</td>
			            <td> <input type="checkbox" id="cbox2" > </td>
		            
		        	</tr>
		            
		        
		    	</tbody>
			</table>
			<div class="row mb-4 justify-content-center" style="height: 50px;">
				<div class="col-4 ml-4">
					<button type="submit" class="btn btn-primary w-100 mt-4 ml-2">Agregar</button>
				</div>
			</div>
		</form>
		
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>