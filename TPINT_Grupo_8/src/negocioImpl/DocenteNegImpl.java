package negocioImpl;

import java.util.ArrayList;
import dao.DocenteDao;
import daoImpl.DocenteDaoImpl;
import entidades.Docente;
import negocio.DocenteNeg;

public class DocenteNegImpl implements DocenteNeg{
	private DocenteDao docDao = new DocenteDaoImpl();
	
	public DocenteNegImpl() {
		
	}

	@Override
	public ArrayList<Docente> listarDocentes() {
		return (ArrayList<Docente>) docDao.readAll();

	}

	@Override
	public boolean agregarDocente(Docente docente) {
		DocenteDao docenteDao = new DocenteDaoImpl();
		return docenteDao.agregarDocente(docente);
		//si quisiera validar q no se pueda agregar un docente y alumno al mismo tiempo
		//entonces crearia una funcion validarDNI y retornaria false si el dni se repite en tablas
		//alumnos o admins
	}

	@Override
	public boolean eliminarDocente(int dni) {
		boolean eliminado =false;
		
		eliminado= docDao.eliminarDocente(dni);
		
		return eliminado;
	}
	
	
	public Docente BuscarDocente(int dni) {

		return docDao.BuscarDocente(dni);
	}
	
	public boolean ModificarDocente(Docente doc) {
		
		return docDao.ModificarDocente(doc);
		
	}

	}

