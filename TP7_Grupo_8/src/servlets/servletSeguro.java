package servlets;

import javax.servlet.RequestDispatcher;
//import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Seguro;
import daoImpl.SeguroDaoImpl;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Completo")!=null) {
			SeguroDaoImpl sdao = new SeguroDaoImpl();
			List<Seguro> lista= sdao.readAll();
			
			request.setAttribute("listaS", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");   
	        rd.forward(request, response);
		}
		
	        
		/*if(request.getParameter("BtnListar")!=null)
		{
			SeguroDaoImpl sdao = new SeguroDaoImpl();
			List<Seguro> lista= sdao.readAllTipoEspecifico();//ACA LE TENGO QUE PASAR EL TIPO QUE VIENE SELCCIONADO EN EL BOTON LISTAR
			
			request.setAttribute("listaS", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");   
	        rd.forward(request, response);
			
		}*/
	}

}
