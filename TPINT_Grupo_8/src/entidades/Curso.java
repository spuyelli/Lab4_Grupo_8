package entidades;

import java.util.ArrayList;

public class Curso {
	private int idCurso;
	private Materia materia;
	private int semestre;
	private int a�o;
	private Persona docente;
	private ArrayList<Persona> alumnos;
	
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	public Persona getDocente() {
		return docente;
	}
	public void setDocente(Persona docente) {
		this.docente = docente;
	}
	public ArrayList<Persona> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Persona> alumnos) {
		this.alumnos = alumnos;
	}
}
