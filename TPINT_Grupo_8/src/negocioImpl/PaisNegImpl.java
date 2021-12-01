package negocioImpl;

import java.util.ArrayList;

import dao.PaisDao;
import daoImpl.PaisDaoImpl;
import entidades.Pais;
import negocio.PaisNeg;

public class PaisNegImpl implements PaisNeg{

	private PaisDao paisDao = new PaisDaoImpl();
	
	public PaisNegImpl() {
	}

	@Override
	public ArrayList<Pais> listarPaises() {
		return (ArrayList<Pais>) paisDao.listarPaises();
	}
	
	public Pais select(int id) {
		return paisDao.select(id);
	}
}
