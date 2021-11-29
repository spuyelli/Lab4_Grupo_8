package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import entidades.Curso;
import entidades.Docente;
import entidades.Materia;
import negocio.AlumnoNeg;
import negocio.CursoNeg;
import negocio.DocenteNeg;
import negocio.MateriaNeg;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.CursoNegImpl;
import negocioImpl.DocenteNegImpl;
import negocioImpl.MateriaNegImpl;

/**
 * Servlet implementation class servletCurso
 */
@WebServlet("/servletCurso")
public class servletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CursoNeg negCur = new CursoNegImpl();
	AlumnoNeg negAlu = new AlumnoNegImpl();
	MateriaNeg negMat = new MateriaNegImpl();
	DocenteNeg negDoc = new DocenteNegImpl();
	
	
    public servletCurso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("Param")!=null)
		{
			String opcion = request.getParameter("Param").toString();
			
			switch (opcion) {
			case "previoAgregar":
			{
				//Se quiere insertar entonces cargo la lista de categorias
				request.setAttribute("listaMat", negMat.listarMaterias());
				request.setAttribute("listaAlumnos", negAlu.listarAlumnos());					
				request.setAttribute("listaDoc", negDoc.listarDocentes());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarCurso.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "list":
			{
				request.setAttribute("listaCur", negCur.listarCursos());	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaCursos.jsp");
				dispatcher.forward(request, response);
				break;
			}
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
	    {
	    	Curso c = new Curso();
	    	Materia m = new Materia();
	    	Docente d = new Docente();
	    	
	    	m.setIdMateria(Integer.parseInt(request.getParameter("selectMateria")));
	    	c.setMateria(m);
	    	d.setDni(Integer.parseInt(request.getParameter("selectDocente")));
	    	c.setDocente(d);
	    	
	    	c.setAño(Integer.parseInt(request.getParameter("inputAnio")));
	    	c.setSemestre(Integer.parseInt(request.getParameter("inputSemestre")));


	    	boolean estado=true;
	    	estado = negCur.insertar(c);
	    	
	    	request.setAttribute("agregado", estado);
	    	if(!estado) {
	    		System.out.println("no pudo agregar");
	    		JOptionPane.showMessageDialog(null, "Error agregando el curso", null, JOptionPane.WARNING_MESSAGE);
	    	}else {
	    		System.out.println("agregado");
	    		JOptionPane.showMessageDialog(null, "Curso agregado correctamente", null, JOptionPane.WARNING_MESSAGE);
	    		
	    	}
	    	
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarCurso.jsp");
			dispatcher.forward(request, response);
	    }
		
		if(request.getParameter("btnCalificaciones")!=null){
			HttpSession session = request.getSession();
			Curso c = new Curso();
			c = negCur.select(Integer.parseInt(request.getParameter("btnCalificaciones").replace("Calificar: ", "")));
			session.setAttribute("Redirect", "true");
			session.setAttribute("Curso", c);
			response.sendRedirect("servletCalificaciones");
			//request.getRequestDispatcher("/servletCalificaciones?").forward(request, response);
	    }
	}

}
