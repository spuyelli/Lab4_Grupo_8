package ejercicio1;

public class Persona {
	
	private String Apellido;
	private String Nombre;
	private String DNI;
	
	public Persona() {}

	public Persona(String apellido, String nombre, String dNI) {
		super();
		Apellido = apellido;
		Nombre = nombre;
		DNI = dNI;
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
	

	
	public  boolean verificarDniInvalido() throws DNIInvalido {
		
		for (int i = 0; i < this.DNI.length(); i++) {
			
			if( this.DNI.charAt(i) < 48 || this.DNI.charAt(i) > 57 ) {
				DNIInvalido exc = new DNIInvalido();
				throw exc; 
			}
		}
		return false;
	}


}
