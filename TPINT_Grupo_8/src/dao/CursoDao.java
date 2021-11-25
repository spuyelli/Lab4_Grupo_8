package dao;

import java.util.List;
import entidades.Curso;

public interface CursoDao {
	public List<Curso> readAll();
	public Curso obtenerUno(int id);
	public boolean insertar(Curso curso);
	public boolean editar(Curso curso);
	public boolean borrar(int id);
}
