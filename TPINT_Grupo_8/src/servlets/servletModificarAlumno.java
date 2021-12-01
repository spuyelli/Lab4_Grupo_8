package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Alumno;
import entidades.Domicilio;
import negocioImpl.AlumnoNegImpl;

/**
 * Servlet implementation class servletModificarAlumno
 */
@WebServlet("/servletModificarAlumno")
public class servletModificarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Domicilio dom = new Domicilio();
		dom.setCalle_Numero(request.getParameter("Domicilio"));
		
		AlumnoNegImpl AlumNeg = new AlumnoNegImpl();
		Alumno al = new Alumno();
		al.setDni(Integer.parseInt(request.getParameter("Dni")));
		al.setNombre(request.getParameter("Nombre"));
		al.setEmail(request.getParameter("Email"));
		al.setApellido(request.getParameter("Apellido"));
		al.setDomicilio(dom);
		al.setFechaNacimiento(LocalDate.parse(request.getParameter("FechaNacimiento")));
		al.setTelefono(Integer.parseInt(request.getParameter("Telefono")));
	
		
		AlumNeg.actualizarAlumno(al);
				
		
		
        response.sendRedirect("servletListarAlumno?Param=list");
		
		// doGet(request, response);
	}

}
