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
import negocioImpl.AlumnoNegImpl;



@WebServlet("/servletListarAlumno")
public class servletListarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AlumnoNeg aNeg = new AlumnoNegImpl(); 
       
    
    public servletListarAlumno() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null)
		{
			request.setAttribute("listaAlumnos", aNeg.listarAlumnos());
			RequestDispatcher dispatcherListar = request.getRequestDispatcher("/ListaAlumnos.jsp");
			dispatcherListar.forward(request, response);					
			
		}
		
		if (request.getParameter("btnModificar") != null) {
			
			Alumno al = new Alumno();
			AlumnoNegImpl alNeg = new AlumnoNegImpl();
			System.out.println(request.getParameter("dniSeleccionado"));
			al = alNeg.buscarAlumno(Integer.parseInt(request.getParameter("dniSeleccionado")));
			request.setAttribute("Alumno", al);
			request.getRequestDispatcher("ModificarAlumno.jsp").forward(request, response);
			
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	
	}

}
