package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Alumno;
import negocio.AlumnoNeg;
import negocio.LocalidadNeg;
import negocio.PaisNeg;
import negocio.ProvinciaNeg;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.PaisNegImpl;
import negocioImpl.ProvinciaNegImpl;

@WebServlet("/servletListarAlumno")
public class servletListarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AlumnoNeg aNeg = new AlumnoNegImpl();
	PaisNeg paisNeg = new PaisNegImpl();
	ProvinciaNeg provinciaNeg = new ProvinciaNegImpl();
	LocalidadNeg localidadesNeg = new LocalidadNegImpl();
	public servletListarAlumno() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		if (request.getParameter("Param") != null) {
			request.setAttribute("listaAlumnos", aNeg.listarAlumnos());
			request.setAttribute("alumnoEliminado", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaAlumnos.jsp");
			dispatcher.forward(request, response);

		}
	
		if (request.getParameter("btn").equals("modificar")) {
			Alumno al = new Alumno();
			AlumnoNegImpl alNeg = new AlumnoNegImpl();
			al = alNeg.buscarAlumno(Integer.parseInt(request.getParameter("dni")));
			
			//DROPDOWN PAISES
			request.setAttribute("paises", paisNeg.listarPaises());
			
			 
			//DROPDOWN PROVINCIAS
			request.setAttribute("provincias", provinciaNeg.listarProvincias());	
			
			//DROPDOWN LOCALIDADES
			request.setAttribute("localidades", localidadesNeg.listarLocalidades());
			
			request.setAttribute("Alumno", al);
			request.getRequestDispatcher("ModificarAlumno.jsp").forward(request, response);
		}
		if (request.getParameter("btn").equals("eliminar")) {
			int dni = Integer.parseInt(request.getParameter("dni"));
			
			boolean eliminado = aNeg.eliminarAlumno(dni);
			
			request.setAttribute("listaAlumnos", aNeg.listarAlumnos());
			request.setAttribute("alumnoEliminado", eliminado);
			
			RequestDispatcher dispatcherListar = request.getRequestDispatcher("ListaAlumnos.jsp");
			dispatcherListar.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		/*
		if (request.getParameter("btnEliminar") != null) {

			int dni = Integer.parseInt(request.getParameter("dniSeleccionado").toString());
			boolean eliminado = aNeg.eliminarAlumno(dni);
			request.setAttribute("alumnoEliminado", eliminado);
			request.setAttribute("listaAlumnos", aNeg.listarAlumnos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaAlumnos.jsp");
			dispatcher.forward(request, response);

		}
		 */
	}
}
