package negocio;

import java.util.List;

import entidades.Calificacion;

public interface CalificacionNeg {
	public boolean update(Calificacion cal);
	public List<Calificacion> readAll(int curso);
}
