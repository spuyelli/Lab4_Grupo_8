package entidades;

public class Docente extends Persona {

	private int legajo;
	private boolean estado;

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
