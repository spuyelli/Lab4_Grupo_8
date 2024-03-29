<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- FONTAWESOME -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
<title>Iniciar Sesi�n</title>
</head>
<body>
<div class="d-flex justify-content-center">
	<h1 class="display-4 mt-3">Iniciar Sesi�n</h1>
	</div>
	<br>	

<div class="container d-flex justify-content-center">
    <form class="card p-3 mt-5 bg-light" method="post" action="servletUser" >
  <div class="mb-3">
    <label for="" class="form-label">DNI</label>
    <input type="number" max="99000000" class="form-control" name="txtDNI" required>
  </div>
  <div class="mb-3">
    <label for="" class="form-label">Contrase�a</label>
    <input type="password" class="form-control" name="txtContrasena" required>
  </div>
  <button type="submit" name="btnLogin" class="btn btn-primary">Login</button>
  <br>
  <%
  	if(session.getAttribute("Login_error") != null){
  		String error = session.getAttribute("Login_error").toString();
  		%>
  		<script type="text/javascript">
        	alert(' <%= error %>');
        </script>
  		<label for="" class="form-label" style="color: red;"><%= error %></label>
  		<%
  	}
  	if(session.getAttribute("Usuario") != null){
  		session.invalidate();
  	}
   %>
  
</form>
</div>

<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>