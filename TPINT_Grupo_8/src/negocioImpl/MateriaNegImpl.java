package negocioImpl;

import java.util.ArrayList;

import dao.MateriaDao;
import daoImpl.MateriaDaoImpl;
import entidades.Materia;
import negocio.MateriaNeg;

public class MateriaNegImpl  implements MateriaNeg{
	private MateriaDao matDao = new MateriaDaoImpl();
	public MateriaNegImpl() {
		
	}

	@Override
	public ArrayList<Materia> listarMaterias() {
		return (ArrayList<Materia>) matDao.readAll();
	}
}
