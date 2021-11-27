package dao;

import java.util.List;
import entidades.Alumno;

public interface AlumnoDao {
	
	public List<Alumno> readAll();
	public boolean agregarAlumno(Alumno alumno);

}
