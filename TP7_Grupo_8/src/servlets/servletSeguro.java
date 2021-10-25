package servlets;

import javax.servlet.RequestDispatcher;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Seguro;
import entidades.TipoSeguro;
import daoImpl.SeguroDaoImpl;
import daoImpl.TipoSeguroDaoImpl;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletSeguro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			if (request.getParameter("Completo") != null) {
			
				SeguroDaoImpl sdao = new SeguroDaoImpl();
				List<Seguro> lista = sdao.readAll();

				request.setAttribute("listaS", lista);

				RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
				rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Completo") != null) {
			
			SeguroDaoImpl sdao = new SeguroDaoImpl();
			List<Seguro> lista = sdao.readAll();

			request.setAttribute("listaS", lista);

			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
		}

		
		  if(request.getParameter("BtnListar")!=null) { 
			  SeguroDaoImpl sdao = new SeguroDaoImpl();
			 int idTipo =  Integer.parseInt(request.getParameter("Seguros")); 
			 List<Seguro> lista= sdao.readAllTipoEspecifico(idTipo);//ACA LE  TENGO QUE PASAR EL TIPO QUE VIENE SELCCIONADO EN EL BOTON LISTAR
		
		  
		  request.setAttribute("listaS", lista);
		  
		  RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");
		  rd.forward(request, response);
		  
		  }
		 

		if (request.getParameter("btnAceptar") != null) {
			Seguro nuevoSeguro;
			TipoSeguroDaoImpl tipoSeguroDaoImpl = new TipoSeguroDaoImpl();
			
			int idSeguro = Integer.parseInt(request.getParameter("lblID"));
			String descripcion = request.getParameter("txtDescripcion");
			TipoSeguro tipoSeguro = tipoSeguroDaoImpl.select(Integer.parseInt(request.getParameter("tiposSeguros"))); 
			float costoCont = Float.parseFloat(request.getParameter("txtContratacion"));
			float costoMax = Float.parseFloat(request.getParameter("txtMaximo"));
			
			//		VALIDACIONES			
			
			nuevoSeguro= new Seguro(idSeguro, descripcion, tipoSeguro, costoCont, costoMax);
			
			SeguroDaoImpl seguroDaoImpl = new SeguroDaoImpl();
			try {
				if(seguroDaoImpl.insert(nuevoSeguro)) {
					getServletContext().getRequestDispatcher("/AgregarSeguro.jsp").forward (request, response);
					System.out.println("Se agregó el siguiente seguro: " + nuevoSeguro.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
