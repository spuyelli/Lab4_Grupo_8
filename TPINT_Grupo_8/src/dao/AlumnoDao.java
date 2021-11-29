package dao;

import java.util.List;
import entidades.Alumno;
import entidades.Curso;

public interface AlumnoDao {
	
	public List<Alumno> readAll();
	public boolean agregarAlumno(Alumno alumno);
	public boolean agregarAlumnoACurso(Alumno alumno, Curso curso);

}
