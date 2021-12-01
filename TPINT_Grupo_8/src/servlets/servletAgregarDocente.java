package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Docente;
import entidades.Domicilio;
import entidades.Localidad;
import entidades.Pais;
import entidades.Provincia;
import entidades.Usuario;
import negocio.DocenteNeg;
import negocio.LocalidadNeg;
import negocio.PaisNeg;
import negocio.ProvinciaNeg;
import negocio.UsuarioNeg;
import negocioImpl.DocenteNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.PaisNegImpl;
import negocioImpl.ProvinciaNegImpl;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class servletAgregarDocente
 */
@WebServlet("/servletAgregarDocente")
public class servletAgregarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaisNeg paisNeg = new PaisNegImpl();
	ProvinciaNeg provinciaNeg = new ProvinciaNegImpl();
	LocalidadNeg localidadesNeg = new LocalidadNegImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarDocente() {
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarDocente.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Docente docenteNuevo = new Docente(
				Integer.parseInt(request.getParameter("inputDNI")),
				request.getParameter("inputNombre"),
				request.getParameter("inputApellido"),
				LocalDate.parse(request.getParameter("inputFechaNacimiento")),
				new Pais(Integer.parseInt(request.getParameter("inputNacionalidad"))),
				new Domicilio(request.getParameter("inputDireccion")),
				new Localidad(Integer.parseInt(request.getParameter("inputLocalidad"))),
				new Provincia(Integer.parseInt(request.getParameter("inputProvincia"))),
				new Pais(Integer.parseInt(request.getParameter("inputPais"))),
				request.getParameter("inputEmail"),
				Integer.parseInt(request.getParameter("inputTelefono"))
				);
		
		DocenteNeg docenteNegocio = new DocenteNegImpl();

        boolean estadoDocenteNuevo = docenteNegocio.agregarDocente(docenteNuevo);
        
        //VALIDO DOCENTE
        if (estadoDocenteNuevo) {
        	request.setAttribute("docenteAgregado", true);
        	
        }
        else {
        	request.setAttribute("docenteError", true);
        	
        }
        //AGREGO USUARIO
        
        Usuario usuarioNuevo = new Usuario(
        		Integer.parseInt(request.getParameter("inputDNI")), 
        		request.getParameter("inputPass"), ///SE DEBE VALIDAR Q LAS 2 contraseñas escritas coincidan
        		2, //TIPO USUARIO EN DOCENTE ES: 2
        		true, 
        		request.getParameter("inputNombre"), 
        		request.getParameter("inputApellido")
        		);
        
        UsuarioNeg usuarioNegocio = new UsuarioNegImpl();
        
        boolean estadoUsuarioNuevo = usuarioNegocio.insert(usuarioNuevo);
        
        //VALIDO USUARIO DOCENTE 
        if (estadoUsuarioNuevo) {
        	request.setAttribute("usuarioAgregado", true);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarDocente.jsp");
			dispatcher.forward(request, response);
        }
        else{
        	request.setAttribute("usuarioError", true);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarDocente.jsp");
        	dispatcher.forward(request, response);
        }

        response.sendRedirect("ListaDocentes.jsp");
	}

}
