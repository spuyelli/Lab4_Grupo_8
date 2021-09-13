package ejercicio1;

public class Persona implements Comparable<Persona>{

	private String Apellido;
	private String Nombre;
	private String DNI;

	public Persona() {
	}

	public Persona(String apellido, String nombre, String dNI) {
		Apellido = apellido;
		Nombre = nombre;
		DNI = dNI;
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


	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
	 * result = prime * result + ((DNI == null) ? 0 : DNI.hashCode()); result =
	 * prime * result + ((Nombre == null) ? 0 : Nombre.hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; Persona other = (Persona) obj; if (Apellido == null) { if
	 * (other.Apellido != null) return false; } else if
	 * (!Apellido.equals(other.Apellido)) return false; if (DNI == null) { if
	 * (other.DNI != null) return false; } else if (!DNI.equals(other.DNI)) return
	 * false; if (Nombre == null) { if (other.Nombre != null) return false; } else
	 * if (!Nombre.equals(other.Nombre)) return false; return true; }
	 */
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
