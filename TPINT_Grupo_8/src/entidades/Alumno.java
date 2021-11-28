package entidades;

import java.time.LocalDate;
import java.util.Date;

public class Alumno extends Persona{
	
	private int legajo;
	private boolean estado;
	
	///Constructor para ListarAlumno
	public Alumno(int dni, int legajo2, String nombre, String apellido, String email, int telefono) {
		super(dni, nombre, apellido, email, telefono);
		this.legajo = legajo2;
		
	}
	///Constructor para AgregarAlumno
	public Alumno(int dni, String nombre, String apellido, LocalDate fechaNacimiento, Pais nacionalidad, Domicilio domicilio, Localidad localidad, Provincia provincia, Pais pais, String email, int telefono) {
		super(dni, nombre, apellido, email, telefono);
		this.estado=true;
		this.setFechaNacimiento(fechaNacimiento);
		this.setNacionalidad(nacionalidad);
		this.setDomicilio(domicilio);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setPais(pais);
	}

	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", estado=" + estado + ", getLegajo()=" + getLegajo() + ", isEstado()="
				+ isEstado() + ", getLocalidad()=" + getLocalidad() + ", getDni()=" + getDni() + ", getNombre()="
				+ getNombre() + ", getApellido()=" + getApellido() + ", getFechaNacimiento()=" + getFechaNacimiento()
				+ ", getDomicilio()=" + getDomicilio() + ", getNacionalidad()=" + getNacionalidad()
				+ ", getProvincia()=" + getProvincia() + ", getPais()=" + getPais() + ", getEmail()=" + getEmail()
				+ ", getTelefono()=" + getTelefono() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
