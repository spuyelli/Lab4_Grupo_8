package dao;

import java.util.List;
import entidades.Alumno;
import entidades.Curso;

public interface AlumnoDao {

	public List<Alumno> readAll();
	public boolean agregarAlumno(Alumno alumno);
	public Alumno select(int dni);
	public Alumno select_all(int dni);
	public boolean agregarAlumnoACurso(Alumno alumno, Curso curso);
	public boolean eliminarAlumno(int dni);

	public Alumno BuscarAlumno(int dni);
	public boolean ModificarAlumno(Alumno alumno);
}
