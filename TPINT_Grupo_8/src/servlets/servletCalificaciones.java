package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.NEW;

import entidades.Calificacion;
import entidades.Curso;
import negocioImpl.CalificacionNegImpl;

/**
 * Servlet implementation class servletCalificaciones
 */
@WebServlet("/servletCalificaciones")
public class servletCalificaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletCalificaciones() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("Redirect") == "true") {
			request.setAttribute("ListaCalificaciones", new CalificacionNegImpl().readAll( ((Curso)session.getAttribute("Curso")).getIdCurso() ));
			request.getRequestDispatcher("ListaCalificaciones.jsp").forward(request, response);
			session.setAttribute("Redirect", null);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
