<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Agregar Curso</title>
</head>
<body>

<h1 class="display-4 mt-5 ml-5">Agregar Curso</h1>

<br>
	<br>
	<div class= "conteiner d-flex justify-content-center">
	<form class="card p-3 bg-light w-75 justify-content-center">
	
	<div class="row mb-4 justify-content-center">
		<div class="col-3 ml-4">
			<div class="form-outline">
				<label for="">Nombre de la Materia: </label>
		   		<input type="text" class="form-control" id="inputNombreMateria" required placeholder="">
			</div>
	    </div>
	    <div class="col-3 pr-4">
		    <div class = "form-outline">
			    <label for="">Semestre: </label>
			    <input type="number" class="form-control" id="inputSemestre">
		    </div>
	    </div>
	    
	 </div>
	 <div class="row mb-4 justify-content-center">
		 <div class="col-3 ml-4">
		    <label for="">A�o: </label>
		    <input type="number" class="form-control" id="inputAnio" style="width: 50%; ">
		    <label for="">Semestre: </label>
		    <INPUT TYPE="radio" name="command" value="0"/>Run
			<INPUT TYPE="radio" NAME="command" VALUE="1"/>Walk
		 </div>
		 <div class="col-3 ml-4">
		    <label for="">Nombre y Apellido del Docente: </label>
		    <input type="text" class="form-control" id="inputDocente"  required placeholder="Perez">
		 </div>
	</div>
	
	 <div class="row mb-4 justify-content-center">
	 	<div class="col-4 ml-4">
	 		<button type="reset" class="btn btn-primary w-100 mt-4 ml-2">Reset</button>
	 		<button type="submit" class="btn btn-primary w-100 mt-4 ml-2">Agregar</button>
	 	</div>
	 </div>
	 
	</form>
	</div>
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>