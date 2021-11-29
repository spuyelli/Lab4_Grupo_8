package negocioImpl;

import java.util.ArrayList;

import dao.CursoDao;
import daoImpl.CursoDaoImpl;
import entidades.Curso;
import entidades.Usuario;
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
	public Curso obtenerUltimo() {
		return curDao.obtenerUltimo();
	}


	@Override
	public boolean insertar(Curso curso) {
		return curDao.insertar(curso);
	}


	@Override
	public Curso select(int id) {
		return curDao.select(id);
	}

	public Curso obtenerUno(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Curso> listarCursosUsuario(int dniUser) {
		return (ArrayList<Curso>) curDao.readAllUser(dniUser);
	}



}
