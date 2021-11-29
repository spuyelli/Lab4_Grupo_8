package entidades;

import negocioImpl.AlumnoNegImpl;

public class Calificacion {
	private int dniAlumno;
	private int idCurso;
	private String nombre;
	
	public Calificacion(int dniAlumno, int idCurso, int parcial1, int parcial2, int recuperatorio1, int recuperatorio2, boolean estadoAprobacion) {
		this.dniAlumno = dniAlumno;
		this.idCurso = idCurso;
		this.nombre = getAlumno().getNombre();
		this.apellido = getAlumno().getApellido();
		this.parcial1 = parcial1;
		this.parcial2 = parcial2;
		this.recuperatorio1 = recuperatorio1;
		this.recuperatorio2 = recuperatorio2;
		this.estadoAprobacion = estadoAprobacion;
	}


	private String apellido;
	private int parcial1;
	private int parcial2;
	private int recuperatorio1;
	private int recuperatorio2;
	private boolean estadoAprobacion;
	
	
	public Calificacion() {
		
	}


	public int getDniAlumno() {
		return dniAlumno;
	}


	public void setDniAlumno(int dniAlumno) {
		this.dniAlumno = dniAlumno;
	}


	public int getIdCurso() {
		return idCurso;
	}


	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}


	public int getParcial1() {
		return parcial1;
	}


	public void setParcial1(int parcial1) {
		this.parcial1 = parcial1;
	}


	public int getParcial2() {
		return parcial2;
	}


	public void setParcial2(int parcial2) {
		this.parcial2 = parcial2;
	}


	public int getRecuperatorio1() {
		return recuperatorio1;
	}


	public void setRecuperatorio1(int recuperatorio1) {
		this.recuperatorio1 = recuperatorio1;
	}


	public int getRecuperatorio2() {
		return recuperatorio2;
	}


	public void setRecuperatorio2(int recuperatorio2) {
		this.recuperatorio2 = recuperatorio2;
	}


	public boolean isestadoAprobacion() {
		return estadoAprobacion;
	}


	public void setestadoAprobacion(boolean estadoAprobacion) {
		this.estadoAprobacion = estadoAprobacion;
	}

	public Alumno getAlumno() {
		return new AlumnoNegImpl().select(this.dniAlumno);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
