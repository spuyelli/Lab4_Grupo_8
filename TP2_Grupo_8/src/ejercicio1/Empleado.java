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
}