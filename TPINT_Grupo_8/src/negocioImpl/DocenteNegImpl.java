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
	public Docente BuscarDocente(int dni) {

		return docDao.BuscarDocente(dni);
	}
	
	public boolean ModificaDocente(Docente doc) {
		docDao.ModificaDocente(doc);
		return false;
	}

	}

