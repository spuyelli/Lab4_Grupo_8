package negocio;

import java.util.ArrayList;

import entidades.Alumno;

public interface AlumnoNeg {
	
	boolean actualizarAlumno(Alumno al);
	ArrayList<Alumno> listarAlumnos();

}
