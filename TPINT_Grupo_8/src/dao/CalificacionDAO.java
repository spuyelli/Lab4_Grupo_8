package dao;

import java.util.List;
import entidades.Calificacion;

public interface CalificacionDAO {
	public boolean update(Calificacion cal, int test);
	public List<Calificacion> readAll(int curso);
	public Calificacion readAll_Alumno(int curso, int dni);
}
