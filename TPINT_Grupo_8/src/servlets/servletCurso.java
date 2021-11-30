package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import entidades.Alumno;
import entidades.Curso;
import entidades.Docente;
import entidades.Materia;
import entidades.Persona;
import entidades.Usuario;
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
	Usuario user = new Usuario();
	Persona per;
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
				
				request.setAttribute("listaMat", negMat.listarMaterias());
				request.setAttribute("listaAlumnos", negAlu.listarAlumnos());					
				request.setAttribute("listaDoc", negDoc.listarDocentes());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarCurso.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "list":
			{	
				Usuario user = new Usuario();
				user = (Usuario)request.getSession().getAttribute("Usuario");
				
				if(user.getTipoUsuario()== 1) {//SI ES ADMIN TRAIGO TODO
					request.setAttribute("listaCur", negCur.listarCursos());		
				}else {
					request.setAttribute("listaCur", negCur.listarCursosUsuario(user.getDni()));
				}
				
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
	    	Alumno alu = new Alumno();
	    	
	    	Curso ultimoCurso;
	    	int nuevoIdCurso;
	    	boolean estado=true;

	    	if(request.getParameter("dniSeleccionado")!=null) {
	    		
	    		ultimoCurso = negCur.obtenerUltimo();
	    		nuevoIdCurso = ultimoCurso.getIdCurso() + 1;
	    		c.setIdCurso(nuevoIdCurso);	    
	    		
	    		//PRIMERO CREO EL CURSO
	    		m.setIdMateria(Integer.parseInt(request.getParameter("selectMateria")));
		    	c.setMateria(m);
		    	d.setDni(Integer.parseInt(request.getParameter("selectDocente")));
		    	c.setDocente(d);
		    	
		    	c.setAño(Integer.parseInt(request.getParameter("inputAnio")));
		    	c.setSemestre(Integer.parseInt(request.getParameter("inputSemestre")));
		    	
		    	estado = negCur.insertar(c);
		    	if(!estado)request.setAttribute("error_curso", "ok");
		    	
		    	//DESPUES AGREGO LOS ALUMNOS AL CURSO
		    	for (String dni : request.getParameterValues("dniSeleccionado")){
		    		alu = new Alumno(Integer.parseInt(dni));
		    		negAlu.agregarAlumnoACurso(alu, c);
		    	}
		    	
		    	
		    	request.setAttribute("agregado", estado);
		    	
		    	
	    	}else {
	    		request.setAttribute("error_dni", "ok");
	    		estado = false;
	    	}
	    	
	    	
	    	if(!estado) {
	    		//est= "error";
	    		System.out.println("no pudo agregar");
	    		
	    	}else {
	    		//est= "ok";
	    		System.out.println("agregado");
	    		request.setAttribute("ok", "ok");
	    	}

	    	request.setAttribute("listaMat", negMat.listarMaterias());
			request.setAttribute("listaAlumnos", negAlu.listarAlumnos());					
			request.setAttribute("listaDoc", negDoc.listarDocentes());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AgregarCurso.jsp");
			dispatcher.forward(request, response);
	    }
		
		if(request.getParameter("btnCalificaciones")!=null){
			HttpSession session = request.getSession();
			Curso c = negCur.select(Integer.parseInt(request.getParameter("btnCalificaciones").replace("Calificar: ", "")));
			session.setAttribute("Redirect", "true");
			session.setAttribute("Curso", c);
			response.sendRedirect("servletCalificaciones");
	    }
	}

}
