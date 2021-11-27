package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Localidad;
import entidades.Provincia;
import entidades.Alumno;
import entidades.Pais;
import negocio.PaisNeg;
import negocio.ProvinciaNeg;
import negocio.LocalidadNeg;
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
				Integer.parseInt(request.getParameter("dni")),
				0,
				request.getParameter("dni"),
				request.getParameter("nombre"),
				request.getParameter("apellido"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("telefono")),
				new Pais(Integer.parseInt(request.getParameter("inputPais"))),
				new Provincia(Integer.parseInt(request.getParameter("inputProvincia"))),
				new Localidad(Integer.parseInt(request.getParameter("inputLocalidad"))), //q hacer con Localidad? ya q es parte de clase direccion
				new Nacionalidad(Integer.parseInt(request.getParameter("inputPais2"))),
				new Domicilio(request.getParameter("inputDireccion"), Integer.parseInt(request.getParameter("inputLocalidad"))),
				new FechaNacimiento(LocalDate.parse(request.getParameter("inputFechaNacimiento"))),
				true //ESTADO
				);
		
		 NegocioAlumno negocioAlumno = new NegocioAlumno();

         int estado = negocioAlumno.agregarAlumno(AlumnoAdd);
	}

}
