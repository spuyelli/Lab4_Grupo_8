package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import entidades.Usuario;
import negocio.usuarioNeg;
import negocioImpl.usuarioNegImpl;

@WebServlet("/servletUser")
public class servletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	usuarioNeg userNegImp = new usuarioNegImpl(); 
	
	public servletUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (request.getParameter("btnLogin") != null) {

			if(request.getParameter("Usuario") != null) {
				//response.sendRedirect("home.jsp");
				return;
			} else {
				Usuario user = userNegImp.select(Integer.parseInt(request.getParameter("txtDNI")));
				if(user == null) {
					session.setAttribute("Login_error", "Usuario incorrecto");
					System.out.println("Usuario incorrecto");
					response.sendRedirect("IniciarSesion.jsp");
					return;
				}
				String passU = user.getPassword();
				String passIN = request.getParameter("txtContraseña");
				if(passU.equals(passIN)) {
					System.out.println("Login correcto");
					session.setAttribute("Usuario", user);
				}
				else {
					session.setAttribute("Login_error", "Contraseña incorrecta.");
					System.out.println("Contraseña incorrecta");
					System.out.println(session.getAttribute("Login_error"));
					response.sendRedirect("IniciarSesion.jsp");
				}
			}
		}
		
/*
		if (request.getParameter("btnAceptar") != null) {
			try {
				
				SeguroDaoImpl sDao = new SeguroDaoImpl();
				ArrayList<Seguro> lista;
				int tipoSeguroFiltrar = Integer.parseInt(request.getParameter("TiposSeguros_listar").trim());

				if (tipoSeguroFiltrar <= 0)
					lista = (ArrayList<Seguro>) sDao.readAll();
				else
					lista = (ArrayList<Seguro>) sDao.readAllTipoEspecifico(tipoSeguroFiltrar);

				request.setAttribute("listaSeguros", lista);

				RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguros.jsp");

				rd.forward(request, response);
				
				
				
				int idSeguro = Integer.parseInt(request.getParameter("lblID").trim());
				String descripcion = request.getParameter("txtDescripcion").trim();
				int tipoSeguro = Integer.parseInt(request.getParameter("tiposSeguros_agregar"));
				float costoCont = Float.parseFloat(request.getParameter("txtContratacion").trim());
				float costoMax = Float.parseFloat(request.getParameter("txtMaximo").trim());

				String validar = "";
				if (idSeguro > 0) {
					if (!descripcion.trim().isEmpty()) {
						if (tipoSeguro > 0) {
							if (costoCont > 0) {
								if (costoMax > 0) {
									Seguro nuevoSeguro = new Seguro(idSeguro, descripcion, tipoSeguro, costoCont,
											costoMax);

									SeguroDaoImpl seguroDaoImpl = new SeguroDaoImpl();
									try {
										if (seguroDaoImpl.insert(nuevoSeguro)) {
											getServletContext().getRequestDispatcher("/AgregarSeguro.jsp")
													.forward(request, response);
											System.out.println(
													"Se agregó el siguiente seguro: " + nuevoSeguro.toString());
											return;
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								} else
									validar += "Costo máximo asegurado";
							} else
								validar += "Costo contratación \n";
						} else
							validar += "Tipo seguro \n";
					} else
						validar += "Descripción \n";
				} else
					validar += "ID seguro \n";

				JOptionPane.showMessageDialog(null, "Error en: \n" + validar, "Ingreso de datos erróneo",
						JOptionPane.WARNING_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "", "Ingreso de datos erróneo", JOptionPane.ERROR_MESSAGE);
			}
		}
		*/
	}

}
