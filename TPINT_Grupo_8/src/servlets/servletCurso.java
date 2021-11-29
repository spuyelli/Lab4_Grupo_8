package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mysql.cj.Session;

import entidades.Alumno;
import entidades.Curso;
import entidades.Docente;
import entidades.Materia;
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
				Usuario user = (Usuario)request.getSession().getAttribute("Usuario");
				System.out.println(user.getApellido()+ " " + user.getTipoUsuario());
				if(user.getTipoUsuario()== 1) {//SI ES ADMIN TRAIGO TODO
					request.setAttribute("listaCur", negCur.listarCursos());		
				}else {
					request.setAttribute("listaCur", negCur.listarCursosUsuario(user));
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
		// TODO Auto-generated method stub
		
		if(request.getParameter("btnAceptar")!=null)
	    {
	    	Curso c = new Curso();
	    	Materia m = new Materia();
	    	Docente d = new Docente();
	    	Alumno a = new Alumno();
	    	
	    	Curso ultimoCurso;
	    	int nuevoIdCurso;
	    	
	    	boolean estado=true;
	    	String est="";

	    	if(request.getParameter("dniSeleccionado")!=null) {
	    		
	    		ultimoCurso = negCur.obtenerUltimo();
	    		nuevoIdCurso = ultimoCurso.getIdCurso() + 1;
	    		c.setIdCurso(nuevoIdCurso);	    
	    		
	    		//PRIMERO CREO EL CURSO
	    		m.setIdMateria(Integer.parseInt(request.getParameter("selectMateria")));
		    	c.setMateria(m);
		    	d.setDni(Integer.parseInt(request.getParameter("selectDocente")));
		    	c.setDocente(d);
		    	
		    	c.setA�o(Integer.parseInt(request.getParameter("inputAnio")));
		    	c.setSemestre(Integer.parseInt(request.getParameter("inputSemestre")));
		    	
		    	estado = negCur.insertar(c);
		    	
		    	//DESPUES AGREGO LOS ALUMNOS AL CURSO
		    	for (String dni : request.getParameterValues("dniSeleccionado")){
		    		Alumno alu = new Alumno(Integer.parseInt(dni));
		    		negAlu.agregarAlumnoACurso(alu, c);
		    	}
		    	
		    	
		    	request.setAttribute("agregado", estado);
		    	
		    	
	    	}else {
	    		estado = false;
	    	}
	    	
	    	
	    	if(!estado) {
	    		est= "error";
	    		System.out.println("no pudo agregar");
	    		JOptionPane.showMessageDialog(null, "Error agregando el curso", null, JOptionPane.WARNING_MESSAGE);
	    	}else {
	    		est= "ok";
	    		System.out.println("agregado");
	    		request.setAttribute("agreagdo", est);
	    		JOptionPane.showMessageDialog(null, "Curso agregado correctamente", null, JOptionPane.WARNING_MESSAGE);
	    	}
	    	request.setAttribute("agreagdo", est);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaCursos.jsp");
			dispatcher.forward(request, response);
	    }
	}

}
