package ejercicio1;

public class Profesor extends Empleado implements Comparable<Profesor> {

	private String cargo;
	private int antiguedadDocente;

	/// Constructores
	public Profesor() {
		super();
		this.cargo = "Sin cargo";
		this.antiguedadDocente = 0;

	}

	public Profesor(String cargo, int antiguedadDocente, String nombre, int edad) {
		super(nombre,edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}

	/// Metodos
	@Override
	public String toString() {
		return super.toString() + " Profesor [cargo=" + cargo + ", antiguedadDocente=" + antiguedadDocente + "]";
	}

	@Override
	public int compareTo(Profesor o) {
		if (o.getID() == this.getID()) {
			return 0;
		}
		if (o.getID() < this.getID()) {
			return -1;
		}
		return 1;
	}
}