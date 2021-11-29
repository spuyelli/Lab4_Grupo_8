package negocio;

import java.util.ArrayList;

import entidades.Alumno;
import entidades.Curso;

public interface AlumnoNeg {
	
	boolean actualizarAlumno(Alumno al);
	ArrayList<Alumno> listarAlumnos();
	boolean agregarAlumno(Alumno alumno);
	boolean agregarAlumnoACurso(Alumno alumno, Curso curso);
}
