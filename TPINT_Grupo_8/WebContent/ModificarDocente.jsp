<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="entidades.Docente "%>
<%@page import ="entidades.Pais" %>
<%@page import ="entidades.Provincia" %>
<%@page import ="entidades.Localidad" %>
<%@page import ="java.util.ArrayList" %>
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
<title>Agregar profesor</title>
</head>
<body>

<% Docente doc = new Docente();   doc = (Docente)request.getAttribute("Docente");%>

<%
         ArrayList<Pais> Paises = new ArrayList<Pais>();
         if(request.getAttribute("paises")!=null)
         {
             Paises = (ArrayList<Pais>)request.getAttribute("paises"); 
         }
         ArrayList<Provincia> Provincias = new ArrayList<Provincia>();
         if(request.getAttribute("provincias")!=null)
         {
             Provincias = (ArrayList<Provincia>)request.getAttribute("provincias"); 
         }
         ArrayList<Localidad> Localidades = new ArrayList<Localidad>();
         if(request.getAttribute("localidades")!=null)
         {
             Localidades = (ArrayList<Localidad>)request.getAttribute("localidades"); 
         }
          %>
	<jsp:include page="Navbar.jsp"></jsp:include>
	<div class="d-flex justify-content-center">
		<h1 class="display-4 mt-3 ml-5">Modificar Docente</h1>
	</div>
	<br>
	<div class="conteiner d-flex justify-content-center">
		<form class="card p-3 bg-light w-75 justify-content-center"  action="servletModificarDocente" method="post">

			<div class="row mb-4 justify-content-center">
				<div class="col-3 ml-4">
					<div class="form-outline">
						<label for="">Legajo</label> <input type="text" class="form-control" id="Legajo" name="Legajo" value="<%=doc.getLegajo() %>" readonly>
					</div>
				</div>
				<div class="col-3 pr-4">
					<div class="form-outline">
						<label for="">Dni</label> <input type="number" class="form-control" id="inputDNI" required placeholder="Dni" name="Dni" value="<%=doc.getDni() %>"  readonly>
					</div>
				</div>
			</div>
			
			<div class="row mb-4 justify-content-center">
				<div class="col-3 ml-4">
					<label for="">Nombre</label> <input type="text" class="form-control" id="inputNombre" required placeholder="Nombre" name="Nombre" value="<%=doc.getNombre() %>" >
				</div>
				<div class="col-3 pr-4">
					<label for="">Apellido</label> <input type="text" class="form-control" id="inputApellido" required placeholder="Apellido" name="Apellido" value="<%=doc.getApellido() %>">
				</div>
			</div>
			
			<div class="row mb-4 justify-content-center">
				<div class="col-3 ml-4">
					<label for="">Direcci�n</label> <input type="text" class="form-control" id="inputDireccion" required placeholder="Domicilio" name="Domicilio" value="<%=doc.getDomicilio().getCalle_Numero() %>">
				</div>
				<div class="col-3 pr-4">
					<label for="">Pa�s de residencia</label> 
					<select class="form-control" name="inputPais" id="inputPais" required>
						<option value="<%=doc.getPais().getIdPais()%>" ><%=doc.getPais().getDescripcion() %></option>
						<%
						for(Pais pais : Paises)
						{
					       	%>
					       	
					       	
					       	<% 
					      
					             %>
					             
					                <option value="<%=pais.getIdPais()%>"><%=pais.getDescripcion() %></option>
					             <%
					             
					     }
     					%>
					</select>
				</div>
			</div>

			<div class="row mb-4 justify-content-center">
				
				<div class="col-3 pr-4">
					<label for="">Localidad</label> 
					<select class="form-control" name="inputLocalidad" id="inputLocalidad" required>
					<option value="<%=doc.getLocalidad().getIdLocalidad()%>"><%=doc.getLocalidad().getDescripcion()%></option>
						<%
							for(Localidad localidad : Localidades)
					         {
					             %>
					                <option value="<%=localidad.getIdLocalidad()%>"><%=localidad.getDescripcion()%></option>
					             <%
					         }
     					%>
					</select>
				</div>
			</div>

			<div class="row mb-4 justify-content-center">
				<div class="col-3 ml-4">
					<label for="">Tel�fono</label> <input type="number" class="form-control" id="inputTelefono" required placeholder="Telefono" name="Telefono" value="<%=doc.getTelefono()%>">
				</div>

				<div class="col-3 pr-4">
					<label for="">Email</label> <input type="email" class="form-control" id="inputEmail" required placeholder="Email" name="Email" value="<%=doc.getEmail()%>">
				</div>
			</div>

			<div class="row mb-4 justify-content-center">
				<div class="col-3 ml-4">
					<label for="">Nacionalidad</label>
					 <select class="form-control" name="inputNacionalidad" id="inputPais" required>
					 <option value="<%=doc.getNacionalidad().getIdPais()%>"><%=doc.getNacionalidad().getDescripcion()%></option>
						 <%	for(Pais pais : Paises)
					         {
					             %>
					                <option value="<%=pais.getIdPais()%>"><%=pais.getDescripcion()%></option>
					             <%
					         }
     					%> 
					</select>
				</div>
				<div class="col-3 pr-4">
					<label for="">Fecha de Nacimiento</label> <input type="date" class="form-control" required id="inputFechaNacimiento" name="FechaNacimiento" value="<%=doc.getFechaNacimiento()%>">
				</div>

			</div>
			<div class="row mb-1 justify-content-center">
				<div class="col-4 ml-4">
					<button type="submit" class="btn btn-primary w-100 mt-4 ml-2">Modificar</button>
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