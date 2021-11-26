package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				request.setAttribute("listaAlu", negAlu.listarAlumnos());
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
		// TODO Auto-generated method stub
		/*
		if(request.getParameter("btnAceptar")!=null)
	    {
	    	Articulo x = new Articulo();
	    	x.setNombre(request.getParameter("txtNombre"));
	    	x.setPrecio(Float.parseFloat(request.getParameter("txtPrecio")));
	    	x.setEstado(Integer.parseInt(request.getParameter("comboEstado")));
	    	x.setCategoria(new Categoria(Integer.parseInt(request.getParameter("comboCat"))));
	    	boolean estado=true;
	    	estado = negArt.insertar(x);
	    	
	    	request.setAttribute("listaCat", negCat.obtenerTodos());
	    	request.setAttribute("estadoArticulo", estado);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertarArticulos.jsp");
			dispatcher.forward(request, response);
	    }*/
	}

}
