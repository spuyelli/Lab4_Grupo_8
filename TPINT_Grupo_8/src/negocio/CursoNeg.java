package negocio;
import java.util.ArrayList;

import entidades.Curso;

public interface CursoNeg {
	public ArrayList<Curso> listarCursos();
	public Curso obtenerUno(int id);
	public boolean insertar(Curso articulo);
	public boolean editar(Curso articulo);
	public boolean borrar(int id);
}
