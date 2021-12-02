package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Alumno;
import entidades.Docente;
import entidades.Domicilio;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.DocenteNegImpl;

/**
 * Servlet implementation class servletModificarDocente
 */
@WebServlet("/servletModificarDocente")
public class servletModificarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
	//	if(request.getParameter(arg0))Integer.parseInt(request.getParameter("dni"));
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("btn").equals("modificar")) {
			Alumno al = new Alumno();
			AlumnoNegImpl alNeg = new AlumnoNegImpl();
			al = alNeg.buscarAlumno(Integer.parseInt(request.getParameter("dni")));
			request.removeAttribute("btn");
			
			//DROPDOWN PAISES
			request.setAttribute("paises", paisNeg.listarPaises());	
			
			//DROPDOWN PROVINCIAS
			request.setAttribute("provincias", provinciaNeg.listarProvincias());	
			
			//DROPDOWN LOCALIDADES
			request.setAttribute("localidades", localidadesNeg.listarLocalidades());	
			
			request.setAttribute("Alumno", al);
			
			System.out.println("Estamos en el btn modificar, servlet modificar");
			
			request.getRequestDispatcher("/ModificarAlumno.jsp").forward(request, response);
			
		}
	}

}
