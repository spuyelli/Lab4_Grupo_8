package controller;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.sun.java.swing.plaf.windows.resources.windows;

import dao.UsuarioDAO;
import daoImpl.UsuarioDAOImpl;
import entidades.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import negocio.usuarioNeg;
import negocio.usuarioNegImpl;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	usuarioNeg userNegImp = new usuarioNegImpl(); 
	
	public servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("btnLogin") != null) {

			if(!request.getParameter("txtDNI").isEmpty()) {
				Usuario user = userNegImp.select(Integer.parseInt(request.getParameter("txtDNI"))); 
				String passU = user.getPassword();
				String passIN = request.getParameter("txtContrase�a");
				if(passU.equals(passIN)) {
					request.setAttribute("Usuario", user);
					JOptionPane.showMessageDialog(null, "Bienvenido DNI: " + user.getDni(), "Login exitoso", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrectos.", "Login incorrecto", JOptionPane.WARNING_MESSAGE);
					System.out.println("usuario o contrase�a incorrectos");
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
													"Se agreg� el siguiente seguro: " + nuevoSeguro.toString());
											return;
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								} else
									validar += "Costo m�ximo asegurado";
							} else
								validar += "Costo contrataci�n \n";
						} else
							validar += "Tipo seguro \n";
					} else
						validar += "Descripci�n \n";
				} else
					validar += "ID seguro \n";

				JOptionPane.showMessageDialog(null, "Error en: \n" + validar, "Ingreso de datos err�neo",
						JOptionPane.WARNING_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "", "Ingreso de datos err�neo", JOptionPane.ERROR_MESSAGE);
			}
		}
		*/
	}

}
