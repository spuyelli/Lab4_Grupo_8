package negocioImpl;

import java.util.ArrayList;

import dao.DocenteDao;
import daoImpl.DocenteDaoImp;
import entidades.Docente;
import negocio.DocenteNeg;

public class DocenteNegImpl implements DocenteNeg{
	private DocenteDao docDao = new DocenteDaoImp();
	
	public DocenteNegImpl() {
		
	}

	@Override
	public ArrayList<Docente> listarDocentes() {
		return (ArrayList<Docente>) docDao.readAll();

	}
}
