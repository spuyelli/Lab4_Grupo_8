package negocioImpl;

import java.util.ArrayList;

import dao.AlumnoDao;
import dao.DocenteDao;
import daoImpl.AlumnoDaoImpl;
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
	
	public boolean ModificaDocente(Docente doc) {
		return docDao.ModificaDocente(doc);
		
	}

	}

