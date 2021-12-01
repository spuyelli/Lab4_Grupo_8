package negocioImpl;

import java.util.ArrayList;

import dao.LocalidadDao;
import daoImpl.LocalidadDaoImpl;
import entidades.Localidad;
import negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg {

	private LocalidadDao localidadDao = new LocalidadDaoImpl();

	@Override
	public ArrayList<Localidad> listarLocalidades() {
		
		return (ArrayList<Localidad>) localidadDao.listarLocalidades();
	}

	@Override
	public Localidad select(int id) {
		return localidadDao.select(id);
	}
	
}
