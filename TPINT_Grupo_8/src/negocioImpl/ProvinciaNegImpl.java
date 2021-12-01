package negocioImpl;

import java.util.ArrayList;

import dao.ProvinciaDao;
import daoImpl.ProvinciaDaoImpl;
import entidades.Provincia;
import negocio.ProvinciaNeg;


public class ProvinciaNegImpl implements ProvinciaNeg{

	private ProvinciaDao provinciaDao = new ProvinciaDaoImpl();

	@Override
	public ArrayList<Provincia> listarProvincias() {
		return (ArrayList<Provincia>) provinciaDao.listarProvincias();
	}
	
	public Provincia select(int id) {
		return provinciaDao.select(id);
	}
	
}
