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
import entidades.Localidad;
import entidades.Pais;
import entidades.Provincia;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.DocenteNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.PaisNegImpl;

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
		
		
			Docente doc = new Docente();
			DocenteNegImpl docNeg = new DocenteNegImpl();
			doc.setDni(Integer.parseInt(request.getParameter("Dni")));
			doc.setNombre(request.getParameter("Nombre"));
			doc.setEmail(request.getParameter("Email"));
			doc.setApellido(request.getParameter("Apellido"));
			doc.setFechaNacimiento(LocalDate.parse(request.getParameter("FechaNacimiento")));
			doc.setTelefono(Integer.parseInt(request.getParameter("Telefono")));
			Domicilio dom = new Domicilio();
			dom.setCalle_Numero(request.getParameter("Domicilio"));
			dom.setLocalidad(new LocalidadNegImpl().select((Integer.parseInt(request.getParameter("inputLocalidad")))));
			doc.setDomicilio(dom);
			
			
			Localidad l = new Localidad(Integer.parseInt(request.getParameter("inputLocalidad")));

		
			Pais p = new Pais(Integer.parseInt(request.getParameter("inputPais")));
			
			
			Pais n = new Pais(Integer.parseInt(request.getParameter("inputNacionalidad")));
			doc.setNacionalidad(n);
			doc.setLocalidad(l);
			doc.setPais(p);
			
			docNeg.ModificarDocente(doc);
			
			
			
			response.sendRedirect("servletListarDocente?Param=list");
						
		}
	}


