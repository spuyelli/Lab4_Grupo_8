package negocio;
import java.util.ArrayList;

import entidades.Curso;
import entidades.Usuario;

public interface CursoNeg {
	public ArrayList<Curso> listarCursos();
	public ArrayList<Curso> listarCursosUsuario(int i);
	public Curso obtenerUno(int id);
	public boolean insertar(Curso articulo);
	public Curso select(int id);
	public Curso obtenerUltimo();
}
