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
        $('#ListaCursos').DataTable();
    	} );
    </script>
    
    <style type="text/css">
    	<jsp:include page="Css/StyleSheet.css"></jsp:include>
	</style>
</head>
<body>
	
	<h2>Listado de Cursos</h2>
	
		
<form method="post" action="Servlet">
	<table id="ListaCursos" class="display">
    	<thead>
        	<tr>
	            <th>ID Curso</th>
	            <th>Materia</th>
	            <th>Semestre</th>
	            <th>Año</th>
	            <th>Docente</th>
	            <th></th>
	        </tr>
    	</thead>
    	<tbody>
    
    		<!-- DATOS DE EJEMPLO. ACA REALIZAMOS LA BUSQUEDA A LA BD  -->
        <tr>
            <td>1</td>
            <td>Laboratorio I</td>
            <td>2do. Cuatrimestre</td>
            <td>2021</td>
            <td>Herrera Tamara</td>
            <td><input type="submit" name="btnCalificaciones1" value="Calificaciones"></input> </td>
            
        </tr>
        <tr>
             <td>2</td>
            <td>Laboratorio II</td>
            <td>1er. Cuatrimestre</td>
            <td>2021</td>
            <td>Herrera Tamara</td>
            <td><input type="submit" name="btnCalificaciones2" value="Calificaciones"></input> </td>
        </tr>
        <tr>
             <td>3</td>
            <td>Laboratorio III</td>
            <td>2do. Cuatrimestre</td>
            <td>2021</td>
            <td>Herrera Tamara</td>
            <td><input type="submit" name="btnCalificaciones3" value="Calificaciones"></input> </td>
        </tr>
       
        
    	</tbody>
	</table>
</form>
	
	</body>
</html>
