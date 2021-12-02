package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.AlumnoNeg;
import negocio.DocenteNeg;
import negocio.LocalidadNeg;
import negocio.PaisNeg;
import negocio.ProvinciaNeg;
import entidades.Alumno;
import entidades.Docente;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.DocenteNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.PaisNegImpl;
import negocioImpl.ProvinciaNegImpl;


@WebServlet("/servletListarDocente")
public class servletListarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DocenteNeg dNeg = new DocenteNegImpl();	
	AlumnoNeg aNeg = new AlumnoNegImpl();
	PaisNeg paisNeg = new PaisNegImpl();
	ProvinciaNeg provinciaNeg = new ProvinciaNegImpl();
	LocalidadNeg localidadesNeg = new LocalidadNegImpl();
       
   
    public servletListarDocente() {
        
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		if(request.getParameter("Param")!=null)
		{
			request.setAttribute("listaDocentes", dNeg.listarDocentes());
			request.setAttribute("docenteEliminado", false);
			RequestDispatcher dispatcherListar = request.getRequestDispatcher("/ListaDocentes.jsp");
			dispatcherListar.forward(request, response);					
			
		}
		
		if (request.getParameter("btn").equals("modificar")) {
			Docente doc = new Docente();
			doc = dNeg.BuscarDocente(Integer.parseInt(request.getParameter("dni")));
			
			//DROPDOWN PAISES
			request.setAttribute("paises", paisNeg.listarPaises());	
			
			//DROPDOWN PROVINCIAS
			request.setAttribute("provincias", provinciaNeg.listarProvincias());	
			
			//DROPDOWN LOCALIDADES
			request.setAttribute("localidades", localidadesNeg.listarLocalidades());	
			
			request.setAttribute("Docente", doc);
			request.getRequestDispatcher("ModificarDocente.jsp").forward(request, response);
		}
		if (request.getParameter("btn").equals("eliminar")) {
			int dni = Integer.parseInt(request.getParameter("dni"));
			
			boolean eliminado = dNeg.eliminarDocente(dni);
			
			request.setAttribute("listaDocentes", dNeg.listarDocentes());
			request.setAttribute("docenteEliminado", eliminado);
			
			RequestDispatcher dispatcherListar = request.getRequestDispatcher("ListaDocentes.jsp");
			dispatcherListar.forward(request, response);	

		}
		
		if(request.getParameter("btn").equals("modificar")) {
			
			
			//ACA SE ELIMINA EL DOCENTE ;3
			
		
		}
	
		
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
/*
		if (request.getParameter("btnEliminar") != null) {
			
			int dni = Integer.parseInt(request.getParameter("dniSeleccionado").toString());
			boolean eliminado = dNeg.eliminarDocente(dni);
			request.setAttribute("docenteEliminado", eliminado);
			request.setAttribute("listaDocentes", dNeg.listarDocentes());
			RequestDispatcher dispatcherListar = request.getRequestDispatcher("/ListaDocentes.jsp");
			dispatcherListar.forward(request, response);
				
			
		}
		
		if (request.getParameter("btnModificar") != null) {
			
	
			int dni = Integer.parseInt(request.getParameter("dniSeleccionado").toString());			
			request.setAttribute("dniSeleccionado", dni);
			request.setAttribute("listaDocentes", dNeg.listarDocentes());
			RequestDispatcher dispatcherListar = request.getRequestDispatcher("/ModificarDocente.jsp");
			dispatcherListar.forward(request, response);
				
			
			
		}
				*/
	}
}

	

