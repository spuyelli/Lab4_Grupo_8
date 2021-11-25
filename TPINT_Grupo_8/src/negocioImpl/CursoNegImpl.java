package negocioImpl;

import java.util.ArrayList;

import dao.CursoDao;
import daoImpl.CursoDaoImpl;
import entidades.Curso;
import negocio.CursoNeg;

public class CursoNegImpl implements CursoNeg{
	
	private CursoDao curDao = new CursoDaoImpl();
	
	//Se puede recibir por constructor
	public CursoNegImpl(CursoDao curDao)
	{
		this.curDao = curDao;
	}
	
	public CursoNegImpl()
	{
	}
	
	@Override
	public ArrayList<Curso> listarCursos() {
		return (ArrayList<Curso>) curDao.readAll();
	}

	@Override
	public Curso obtenerUno(int id) {
		return curDao.obtenerUno(id);
	}

	@Override
	public boolean insertar(Curso curso) {
		return curDao.insertar(curso);
	}

	@Override
	public boolean editar(Curso curso) {
		return curDao.editar(curso);
	}

	@Override
	public boolean borrar(int id) {
		
		return curDao.borrar(id);
	}

	
}
