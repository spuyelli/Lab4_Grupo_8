package ejercicio1;

public class Empleado {
	private final int id;
	private String nombre;
	private int edad;
	private static int cont = 1000;


	/// Constructores
	public Empleado() {
		this.id = ++cont;
		this.nombre = "Sin nombre";
		this.edad = 99;

	}

	public Empleado(String nombre, int edad) {
		this.id = ++cont;
		this.nombre = nombre;
		this.edad = edad;
	}

	/// Metodos
	public static int devuelveProximoID() {
		System.out.println("El próximo ID será el: ");
		return cont + 1;
	}

	@Override
	public String toString() {
		return "Empleado ID= " + id + ", Nombre= " + nombre + ", Edad= " + edad;
	}

	protected int getID() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (edad != other.edad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}