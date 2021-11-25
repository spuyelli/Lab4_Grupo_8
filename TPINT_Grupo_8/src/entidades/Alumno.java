package entidades;

public class Alumno extends Persona{
	
	private int legajo;
	private boolean estado;
	
	///Constructor para ListarAlumno
	public Alumno(int dni, int legajo2, String nombre, String apellido, String email, int telefono) {
		super(dni, nombre, apellido, email, telefono);
		this.legajo = legajo2;
		
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
		return "Alumno [legajo=" + legajo + ", estado=" + estado + ", getLegajo()=" + getLegajo() + ", getEstado()="
				+ getEstado() + ", getDni()=" + getDni() + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getDomicilio()=" + getDomicilio() + ", getNacionalidad()=" + getNacionalidad()
				+ ", getEmail()=" + getEmail() + ", getTelefono()=" + getTelefono() + ", getFechaNacimiento()="
				+ getFechaNacimiento() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


}
