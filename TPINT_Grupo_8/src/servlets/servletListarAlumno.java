package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Alumno;
import negocio.AlumnoNeg;
import negocioImpl.AlumnoNegImpl;



@WebServlet("/servletListarAlumno")
public class servletListarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AlumnoNeg aNeg = new AlumnoNegImpl(); 
       
    
    public servletListarAlumno() {
       
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//IF PARA MOSTRAR MENSAJE DE AGREGADO a la BD correctamente
		if(request.getSession().getAttribute("mensaje")!=null && request.getSession().getAttribute("mensaje").toString().equalsIgnoreCase("success")){ //pregunta si la session tiene un atributo llamado mensaje y cuyo contenido es success que viene del servletAgregarAlumno
			request.setAttribute("alumnoAgregado", true); //entonces agregamos un atributo a una variable en el request para leerlo en el listarAlumno.jsp 
			request.getSession().removeAttribute("mensaje"); //elimina la variable mensaje pq sino cada vez q cargue el listado mostrara el mensaje de agregado con exito
		}
			
		if(request.getParameter("Param")!=null)
		{
			request.setAttribute("listaAlumnos", aNeg.listarAlumnos());
			request.setAttribute("alumnoEliminado", false);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaAlumnos.jsp");
			dispatcher.forward(request, response);					
			
		}
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnModificar") != null) {
			
			Alumno al = new Alumno();
			AlumnoNegImpl alNeg = new AlumnoNegImpl();
			System.out.println(request.getParameter("dniSeleccionado"));
			al = alNeg.buscarAlumno(Integer.parseInt(request.getParameter("dniSeleccionado")));
			request.setAttribute("Alumno", al);
			request.getRequestDispatcher("ModificarAlumno.jsp").forward(request, response);
			
		}
		
		if (request.getParameter("btnEliminar") != null) {
			
			int dni = Integer.parseInt(request.getParameter("dniSeleccionado").toString());
			boolean eliminado = aNeg.eliminarAlumno(dni);
			request.setAttribute("alumnoEliminado", eliminado);		
			request.setAttribute("listaAlumnos", aNeg.listarAlumnos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaAlumnos.jsp");
			dispatcher.forward(request, response);	
				
			
		}		
	
	}

}
