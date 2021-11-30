package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Calificacion;
import entidades.Curso;
import negocio.CalificacionNeg;
import negocioImpl.CalificacionNegImpl;

/**
 * Servlet implementation class servletCalificaciones
 */
@WebServlet("/servletCalificaciones")
public class servletCalificaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CalificacionNeg cNeg = new CalificacionNegImpl();

	public servletCalificaciones() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("Redirect") == "true") {
			request.setAttribute("ListaCalificaciones", 
					cNeg.readAll
					( ((Curso)request.getSession().getAttribute("Curso")).getIdCurso() ));
			request.getRequestDispatcher("ListaCalificaciones.jsp").forward(request, response);
			request.getSession().setAttribute("Redirect", null);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		if (request.getParameter("btnAplicarSeleccion") != null) {
			Calificacion cal;
			for (String dni : request.getParameterValues("chk")) {
				cal = cNeg.readAll_Alumno((((Curso) request.getSession().getAttribute("Curso")).getIdCurso()),
						Integer.parseInt(dni));
				switch (request.getParameter("Notas")) {
				case "Parcial1":
					cNeg.update(cal, 1);
					break;
				case "Parcial2":
					cNeg.update(cal, 2);
					break;
				case "Recuperatorio1":
					cNeg.update(cal, 3);
					break;
				case "Recuperatorio2":
					cNeg.update(cal, 4);
					break;
				default:
					break;
				}
			}
		}

	}

}
