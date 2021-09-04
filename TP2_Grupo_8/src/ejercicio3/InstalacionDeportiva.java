package ejercicio3;

public class InstalacionDeportiva extends Edificio{
	
	private String tipo_instalacion;
	
	
	//CONSTRUCTORES
	public InstalacionDeportiva() {
		super();
		this.tipo_instalacion="-";
	}
	
	public InstalacionDeportiva(Double superficie, String tipo_instalacion) {
		super(superficie);
		this.tipo_instalacion = tipo_instalacion;
	}
	
	
	//GETERS SETERS
	public String getTipo_instalacion() {
		return tipo_instalacion;
	}

	public void setTipo_instalacion(String tipo_instalacion) {
		this.tipo_instalacion = tipo_instalacion;
	}

	@Override
	public String toString() {
		return "InstalacionDeportiva: tipo_instalacion=" + tipo_instalacion + ", superficieEdificio="
				+ getSuperficieEdificio() ;
	}

	
	
}
