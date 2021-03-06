package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Localidad;
import entidades.Provincia;
import entidades.Alumno;
import entidades.Domicilio;
import entidades.Pais;
import negocio.PaisNeg;
import negocio.ProvinciaNeg;
import negocio.AlumnoNeg;
import negocio.LocalidadNeg;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.PaisNegImpl;
import negocioImpl.ProvinciaNegImpl;


/**
 * Servlet implementation class servletAgregarAlumno
 */
@WebServlet("/servletAgregarAlumno")
public class servletAgregarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaisNeg paisNeg = new PaisNegImpl();
	ProvinciaNeg provinciaNeg = new ProvinciaNegImpl();
	LocalidadNeg localidadesNeg = new LocalidadNegImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//DROPDOWN PAISES
		request.setAttribute("paises", paisNeg.listarPaises());	
		
		//DROPDOWN PROVINCIAS
		request.setAttribute("provincias", provinciaNeg.listarProvincias());	
		
		//DROPDOWN LOCALIDADES
		request.setAttribute("localidades", localidadesNeg.listarLocalidades());	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarAlumno.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Alumno alumnoNuevo = new Alumno(
				Integer.parseInt(request.getParameter("inputDNI")),
				request.getParameter("inputNombre"),
				request.getParameter("inputApellido"),
				LocalDate.parse(request.getParameter("inputFechaNacimiento")),
				new Pais(Integer.parseInt(request.getParameter("inputNacionalidad"))),
				new Domicilio(request.getParameter("inputDireccion")),
				new Localidad(Integer.parseInt(request.getParameter("inputLocalidad"))),
				new Provincia(Integer.parseInt(request.getParameter("inputProvincia"))),
				new Pais(Integer.parseInt(request.getParameter("inputPais"))),
				request.getParameter("inputEmail"),
				Integer.parseInt(request.getParameter("inputTelefono"))
				);
		
		AlumnoNeg alumnoNegocio = new AlumnoNegImpl();
		
		boolean estadoAlumnoNuevo = alumnoNegocio.agregarAlumno(alumnoNuevo);
        
		
        //VALIDACIONES 
        
        //DROPDOWN PAISES
      	request.setAttribute("paises", paisNeg.listarPaises());	
      	//DROPDOWN PROVINCIAS
      	request.setAttribute("provincias", provinciaNeg.listarProvincias());	
      	//DROPDOWN LOCALIDADES
      	request.setAttribute("localidades", localidadesNeg.listarLocalidades());	
      	RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarAlumno.jsp");
      		
        if (estadoAlumnoNuevo) {
        	
        	request.setAttribute("alumnoAgregado", true);
        }
        else {
        	request.setAttribute("alumnoError", true);
        }
        dispatcher.forward(request, response);
	}

}
