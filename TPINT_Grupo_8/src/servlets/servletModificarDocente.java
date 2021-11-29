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
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Domicilio dom = new Domicilio();
		dom.setCalle_Numero(request.getParameter("Domicilio"));
		
		DocenteNegImpl DocNeg = new DocenteNegImpl();
		Docente doc = new Docente();
		doc.setDni(Integer.parseInt(request.getParameter("Dni")));
		doc.setNombre(request.getParameter("Nombre"));
		doc.setEmail(request.getParameter("Email"));
		doc.setApellido(request.getParameter("Apellido"));
		doc.setDomicilio(dom);
		doc.setFechaNacimiento(LocalDate.parse(request.getParameter("FechaNacimiento")));
		doc.setTelefono(Integer.parseInt(request.getParameter("Telefono")));
	
		
		DocNeg.ModificaDocente(doc);
				
				//la domada es ahi
		
		
		doGet(request, response);
	}

}
