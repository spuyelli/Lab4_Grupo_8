package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Alumno;
import entidades.Docente;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.DocenteNegImpl;


@WebServlet("/servletListarDocente")
public class servletListarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servletListarDocente() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Docente doc = new Docente();
		DocenteNegImpl docNeg = new DocenteNegImpl();
		doc = docNeg.BuscarDocente(Integer.parseInt(request.getParameter("dniSeleccionado")));
		request.setAttribute("Docente", doc);
		request.getRequestDispatcher("ModificarAlumno.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
