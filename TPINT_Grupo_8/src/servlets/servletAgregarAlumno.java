package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		/**
		Alumno alumnoNuevo = new Alumno(
				Integer.parseInt(request.getParameter("dni")),
				0,
				request.getParameter("dni")
				);
		**/
	}

}
