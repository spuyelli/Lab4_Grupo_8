package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entidades.Pais;
import negocio.paisNeg;
import negocioImpl.paisNegImpl;

/**
 * Servlet implementation class servletAgregarAlumno
 */
@WebServlet("/servletAgregarAlumno")
public class servletAgregarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAgregarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		paisNeg PaisNeg = new paisNegImpl();
		ArrayList<Pais> paises = new ArrayList<Pais>();
		paises = PaisNeg.listarPaises();
		request.setAttribute("paises", paises);
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumno.jsp");  
        rd.forward(request, response);
      
        /**
         paisNeg NegPais = new paisNegImpl(); 
		ArrayList<Pais> paises = new ArrayList<Pais>();
		paises = NegPais.listarPaises(); 
		request.setAttribute("paises", paises);
       ----
       el de abajo es ultimo
       ----
		Pais paises = null;
		request.setAttribute("paises", paises);
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarAlumno.jsp");  
        rd.forward(request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int filas = 0;
		if(request.getParameter("btnAceptar")!=null) {
			
		}
	}

}
