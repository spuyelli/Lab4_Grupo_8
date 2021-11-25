package negocioImpl;

import java.util.ArrayList;

import dao.PaisDao;
import daoImpl.PaisDaoImpl;
import entidades.Pais;
import negocio.paisNeg;

public class paisNegImpl implements paisNeg{

	private PaisDao paisDao = new PaisDaoImpl();
		
	@Override
	public ArrayList<Pais> listarPaises() {
		
		return (ArrayList<Pais>) paisDao.listarPaises();
	
	}

}
