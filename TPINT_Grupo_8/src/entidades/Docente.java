package entidades;

import java.time.LocalDate;

public class Docente extends Persona {

	private int legajo;
	private boolean estado;
	
	
	public Docente() {
	}

	public Docente(int dni2, String nombre2, String apellido2, String email2, int telefono2) {
		super(dni2, nombre2, apellido2, email2, telefono2);
		// TODO Auto-generated constructor stub
	}

	///Constructor para AgregarDocente
	public Docente(int dni, String nombre, String apellido, LocalDate fechaNacimiento, Pais nacionalidad, Domicilio domicilio, Localidad localidad, Provincia provincia, Pais pais, String email, int telefono) {
				super(dni, nombre, apellido, email, telefono);
				this.estado=true;
				this.setFechaNacimiento(fechaNacimiento);
				this.setNacionalidad(nacionalidad);
				this.setDomicilio(domicilio);
				this.setLocalidad(localidad);
				this.setProvincia(provincia);
				this.setPais(pais);
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
		return "Legajo= " + legajo;
	}
	
	
}
