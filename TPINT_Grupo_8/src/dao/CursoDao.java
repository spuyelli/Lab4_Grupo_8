package dao;

import java.util.List;
import entidades.Curso;
import entidades.Usuario;

public interface CursoDao {
	public List<Curso> readAll();
	public List<Curso> readAllUser(Usuario user);
	public Curso obtenerUno(int id);
	public boolean insertar(Curso curso);
	public boolean editar(Curso curso);
	public boolean borrar(int id);
	public Curso select(int id);
	Curso obtenerUltimo();
}
