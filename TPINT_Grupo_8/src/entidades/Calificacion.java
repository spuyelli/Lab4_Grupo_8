package entidades;

import negocioImpl.AlumnoNegImpl;

public class Calificacion {
	private int dniAlumno;
	private int idCurso;
	private String nombre;
	private String apellido;
	private float parcial1;
	private float parcial2;
	private float recuperatorio1;
	private float recuperatorio2;
	private boolean estadoAprobacion;

	public Calificacion(int dniAlumno, int idCurso, float parcial1, float parcial2, float recuperatorio1, float recuperatorio2, boolean estadoAprobacion) {
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

	public float getParcial1() {
		return parcial1;
	}

	public void setParcial1(float parcial1) {
		this.parcial1 = parcial1;
	}

	public float getParcial2() {
		return parcial2;
	}

	public void setParcial2(float parcial2) {
		this.parcial2 = parcial2;
	}

	public float getRecuperatorio1() {
		return recuperatorio1;
	}

	public void setRecuperatorio1(float recuperatorio1) {
		this.recuperatorio1 = recuperatorio1;
	}

	public float getRecuperatorio2() {
		return recuperatorio2;
	}

	public void setRecuperatorio2(float recuperatorio2) {
		this.recuperatorio2 = recuperatorio2;
	}

	public boolean isestadoAprobacion() {
		return estadoAprobacion;
	}

	public void setestadoAprobacion(boolean estadoAprobacion) {
		this.estadoAprobacion = estadoAprobacion;
	}

	public Alumno getAlumno() {
		return new AlumnoNegImpl().select_all(this.dniAlumno);
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
