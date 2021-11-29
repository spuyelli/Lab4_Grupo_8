package negocio;
import java.util.ArrayList;

import entidades.Curso;
import entidades.Usuario;

public interface CursoNeg {
	public ArrayList<Curso> listarCursos();
	public ArrayList<Curso> listarCursosUsuario(Usuario user);
	public Curso obtenerUno(int id);
	public boolean insertar(Curso articulo);
	public boolean editar(Curso articulo);
	public boolean borrar(int id);
	public Curso select(int id);
	public Curso obtenerUltimo();
}
