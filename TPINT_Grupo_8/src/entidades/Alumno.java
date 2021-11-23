package entidades;

public class Alumno extends Persona{
	
	private int legajo;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
