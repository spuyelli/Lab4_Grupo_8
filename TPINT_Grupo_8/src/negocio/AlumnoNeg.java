package negocio;

import java.util.ArrayList;
import entidades.Alumno;

public interface AlumnoNeg {
	
	public boolean actualizarAlumno(Alumno al);
	public ArrayList<Alumno> listarAlumnos();
	public boolean agregarAlumno(Alumno alumno);
	public Alumno select(int dni);
}
