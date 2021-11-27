package negocioImpl;

import java.util.ArrayList;

import dao.PaisDao;
import daoImpl.PaisDaoImpl;
import entidades.Pais;
import negocio.PaisNeg;

public class PaisNegImpl implements PaisNeg{

	private PaisDao paisDao = new PaisDaoImpl();
		
	@Override
	public ArrayList<Pais> listarPaises() {
		
		return (ArrayList<Pais>) paisDao.listarPaises();
	
	}

}
