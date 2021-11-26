package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.alumnoNeg;
import negocioImpl.alumnoNegImp;


@WebServlet("/servletListarAlumno")
public class servletListarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	alumnoNeg aNeg = new alumnoNegImp(); 
       
    
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
			RequestDispatcher dispatcherModificar = request.getRequestDispatcher("/ModificarAlumno.jsp");
			dispatcherModificar.forward(request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	
	}

}
