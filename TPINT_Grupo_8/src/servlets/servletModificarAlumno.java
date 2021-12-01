package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Alumno;
import entidades.Domicilio;
import entidades.Localidad;
import entidades.Pais;
import entidades.Provincia;
import negocio.LocalidadNeg;
import negocio.PaisNeg;
import negocio.ProvinciaNeg;
import negocioImpl.AlumnoNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.PaisNegImpl;
import negocioImpl.ProvinciaNegImpl;

/**
 * Servlet implementation class servletModificarAlumno
 */
@WebServlet("/servletModificarAlumno")
public class servletModificarAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaisNeg paisNeg = new PaisNegImpl();
	ProvinciaNeg provinciaNeg = new ProvinciaNegImpl();
	LocalidadNeg localidadesNeg = new LocalidadNegImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletModificarAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//si funciona eliminar lo del do get
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//DROPDOWN PAISES
		request.setAttribute("paises", paisNeg.listarPaises());	
		
		//DROPDOWN PROVINCIAS
		request.setAttribute("provincias", provinciaNeg.listarProvincias());	
		
		//DROPDOWN LOCALIDADES
		
		
		request.setAttribute("localidades", localidadesNeg.listarLocalidades());	
		AlumnoNegImpl AlumNeg = new AlumnoNegImpl();
		Alumno al = new Alumno();
		al.setDni(Integer.parseInt(request.getParameter("Dni")));
		al.setNombre(request.getParameter("Nombre"));
		al.setEmail(request.getParameter("Email"));
		al.setApellido(request.getParameter("Apellido"));
		al.setFechaNacimiento(LocalDate.parse(request.getParameter("FechaNacimiento")));
		al.setTelefono(Integer.parseInt(request.getParameter("Telefono")));
		Domicilio dom = new Domicilio();
		dom.setCalle_Numero(request.getParameter("Domicilio"));
		dom.setLocalidad(new LocalidadNegImpl().select((Integer.parseInt(request.getParameter("inputLocalidad")))));
		al.setDomicilio(dom);
		Pais n = new Pais(Integer.parseInt(request.getParameter("inputNacionalidad")));
		Localidad l = new Localidad(Integer.parseInt(request.getParameter("inputLocalidad")));
		Provincia prov = new Provincia(Integer.parseInt(request.getParameter("inputProvincia")));
		Pais p = new Pais(Integer.parseInt(request.getParameter("inputPais")));
		
		al.setNacionalidad(n);
		al.setLocalidad(l);
		al.setProvincia(prov);
		al.setPais(p);
		
		AlumNeg.actualizarAlumno(al);
		


        response.sendRedirect("servletListarAlumno?Param=list");
		
		// doGet(request, response);
	}

}
