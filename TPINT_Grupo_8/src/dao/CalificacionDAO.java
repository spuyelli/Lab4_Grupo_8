package dao;

import java.util.List;
import entidades.Calificacion;

public interface CalificacionDAO {
	public boolean update(Calificacion cal);
	public List<Calificacion> readAll(int curso); 
}
