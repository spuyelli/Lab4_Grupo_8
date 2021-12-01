package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import entidades.Usuario;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;

@WebServlet("/servletUser")
public class servletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioNeg userNegImp = new UsuarioNegImpl(); 
	
	public servletUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session == null) {
			request.getSession(true);
		}
		if (request.getParameter("btnLogin") != null) {

			if(request.getParameter("Usuario") != null) {
				session.invalidate();
				return;
			} else {
				Usuario user = userNegImp.select(Integer.parseInt(request.getParameter("txtDNI")));
				if(user == null) {
					session.setAttribute("Login_error", "Usuario incorrecto");
					response.sendRedirect("IniciarSesion.jsp");
					return;
				}
				String passU = user.getPassword();
				String passIN = request.getParameter("txtContraseña");
				if(passU.equals(passIN)) {
					user.setDomicilio(null);
					user.setEmail("");
					user.setFechaNacimiento(null);
					user.setLocalidad(null);
					user.setNacionalidad(null);;
					user.setPais(null);
					user.setPassword("");
					user.setProvincia(null);
					user.setTelefono(0);
					session.setAttribute("Usuario", user);
					session.setMaxInactiveInterval(60*3);
					response.sendRedirect("Home.jsp");
				}
				else {
					session.setAttribute("Login_error", "Contraseña incorrecta");
					response.sendRedirect("IniciarSesion.jsp");
				}
			}
		}
	}

}
