package ejercicio1;

public class Persona implements Comparable<Persona>{

	private String Apellido;
	private String Nombre;
	private String DNI;

	public Persona() {
	}

	public Persona(String apellido, String nombre, String dNI) {
		this.Apellido = apellido;
		this.Nombre = nombre;
		this.DNI = dNI;
	}

	public Persona(String linea) {
		this.Nombre = linea.substring(0, linea.indexOf('-'));
		this.Apellido = linea.substring(linea.indexOf('-') + 1, linea.lastIndexOf('-'));
		this.DNI = linea.substring(linea.lastIndexOf('-') + 1);
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public static boolean verificarDniInvalido(String dni) throws DNIInvalido {

		for (int i = 0; i < dni.length(); i++) {

			if (!Character.isDigit(dni.charAt(i))) {
				throw new DNIInvalido();
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return this.Apellido + "-" + this.Nombre + "-" + this.DNI;
	}

	@Override
	public int compareTo(Persona persona) {
		int aux = persona.Apellido.compareTo(this.Apellido);
		if( aux == 0)
			return 0;
		if (aux < 0)
		{
			return 1;
		}		
		return -1;
	}

}
