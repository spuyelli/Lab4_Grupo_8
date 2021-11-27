<%@page import="entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-light bg-light ">
  <h1 class="ml-3 font-weight-bold"><a class="navbar-brand" href="Home.jsp">UTN</a></h1>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse ml-5 mr-5" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle h5" href="#" id="dropdownAlumnos" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="display: none;">
          Alumnos
        </a>
        <div class="dropdown-menu" aria-labelledby="dropdownAlumnos">

         	<a class="dropdown-item" href="servletListarAlumno?Param=list">Listado Alumnos</a>
        	<a class="dropdown-item" href="servletAgregarAlumno?Param=list">Agregar Alumno</a> 

        </div>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle h5" href="#" id="dropdownDocentes" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="display: none;">
          Docentes
        </a>
        <div class="dropdown-menu" aria-labelledby="dropdownDocentes">
          <a class="dropdown-item" href="ListaDocentes.jsp">Listado Docentes</a>
          <a class="dropdown-item" href="AgregarDocente.jsp">Agregar Docente</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle h5" href="#" id="dropdownCursos" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Cursos
        </a>
        <div class="dropdown-menu" aria-labelledby="dropdownCursos">
          <a class="dropdown-item" href="servletCurso?Param=list">Listado Cursos</a>
          <a class="dropdown-item" href="servletCurso?Param=previoAgregar" id="agregarCursos" style="display: none;">Agregar Cursos</a>     
        </div>
      </li>
<!-- 
      <li class="nav-item mr-2 h5">
        <a class="nav-link " href="ListaCursos.jsp" id="listaCurso" >
          Mis Cursos
        </a>
        
      </li>
 -->
    </ul>
    <div class= "d-flex justify-content-end">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link mr-2 h5" href="Home.jsp" id="botonUsuario"  >
         <i class="fas fa-user"></i> <!--  @usuario(@tipoUsuario)--> 
         <%
			if(session.getAttribute("Usuario") != null) {
				Usuario user = (Usuario)session.getAttribute("Usuario");
				String nombreApellido = user.getNombreApellido();
				%>
				<label for="" class="form-label" style="color: red"> <%= nombreApellido %> </label>
				<%
			}
			else{
				request.getRequestDispatcher("IniciarSesion.jsp").forward(request, response);
			}
		%>
        </a>
      </li>
            
      <li class="nav-item  h5">
        <a class="nav-link " href="IniciarSesion.jsp" id="cerrarSesion">
          Cerrar sesión
        </a>
        
      </li>
      
    </ul>
    </div>
  </div>
</nav>
<%
	if(session.getAttribute("Usuario") != null) {
		Usuario user = (Usuario)session.getAttribute("Usuario"); 
		int tipoU = user.getTipoUsuario();
    	if(tipoU != 1){
    	%>
		    	<script type="text/javascript">
		        document.getElementById("dropdownAlumnos").onclick = function() {
		            document.getElementById("dropdownAlumnos").style.display = "none";
		        }
		  
		        document.getElementById("dropdownDocentes").onclick = function() {
		            document.getElementById("dropdownDocentes").style.display = "none";
		        }

		        document.getElementById("agregarCursos").onclick = function() {
		            document.getElementById("agregarCursos").style.display = "none";
		        }
		    </script>
		<%
    	}
    	else{
    	%>
    		<script type="text/javascript">
            document.getElementById("dropdownAlumnos").style.display = "block";
  		
            document.getElementById("dropdownDocentes").style.display = "block";

            document.getElementById("agregarCursos").style.display = "block";
			</script>
		<%
		}
	}
    %>
</body>