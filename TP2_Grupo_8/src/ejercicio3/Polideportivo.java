package ejercicio3;

public class Polideportivo extends InstalacionDeportiva{
	private String nombre;
	
	public Polideportivo() {
		super();
	}
	
	public Polideportivo( Double sup, String tipo,String nombre) {
		super(sup, tipo);
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Polideportivo: nombre=" + nombre +  ", tipo de instalacion="
				+ getTipo_instalacion() + ", superficie edif=" +super.getSuperficieEdificio() ;
	}
	
	
}
