package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.DocenteNeg;
import entidades.Alumno;
import entidades.Docente;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.DocenteNegImpl;


@WebServlet("/servletListarDocente")
public class servletListarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DocenteNeg dNeg = new DocenteNegImpl();	
       
   
    public servletListarDocente() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		if(request.getParameter("Param")!=null)
		{
			request.setAttribute("listaDocentes", dNeg.listarDocentes());
			request.setAttribute("docenteEliminado", false);
			RequestDispatcher dispatcherListar = request.getRequestDispatcher("/ListaDocentes.jsp");
			dispatcherListar.forward(request, response);					
			
		}
		
		if (request.getParameter("btnModificar") != null) {
			
			int dni = Integer.parseInt(request.getParameter("dniSeleccionado").toString());
			System.out.println("EL DNI SELECCIONADO ES "+dni);
			request.setAttribute("dniSeleccionado", dni);
			RequestDispatcher dispatcherModificar = request.getRequestDispatcher("/ModificarDocente.jsp");
			dispatcherModificar.forward(request, response);
		}
		
		
		
	/*	Docente doc = new Docente();
		DocenteNegImpl docNeg = new DocenteNegImpl();
		doc = docNeg.BuscarDocente(Integer.parseInt(request.getParameter("dniSeleccionado")));
		request.setAttribute("Docente", doc);
		request.getRequestDispatcher("ModificarAlumno.jsp").forward(request, response);
	*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
if (request.getParameter("btnEliminar") != null) {
			
			int dni = Integer.parseInt(request.getParameter("dniSeleccionado").toString());
			boolean eliminado = dNeg.eliminarDocente(dni);
			request.setAttribute("docenteEliminado", eliminado);
			request.setAttribute("listaDocentes", dNeg.listarDocentes());
			RequestDispatcher dispatcherListar = request.getRequestDispatcher("/ListaDocentes.jsp");
			dispatcherListar.forward(request, response);
				
			
		}
		

		}
	}
