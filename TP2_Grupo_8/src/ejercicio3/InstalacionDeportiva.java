package ejercicio3;

public class InstalacionDeportiva extends Edificio{
	
	private int tipo_instalacion;
	
	
	//CONSTRUCTORES
	public InstalacionDeportiva() {
		super();
		this.tipo_instalacion=0;
	}
	
	public InstalacionDeportiva(Double superficie, int tipo_instalacion) {
		super(superficie);
		this.tipo_instalacion = tipo_instalacion;
	}
	
	
	//GETERS SETERS
	public int getTipo_instalacion() {
		return tipo_instalacion;
	}

	public void setTipo_instalacion(int tipo_instalacion) {
		this.tipo_instalacion = tipo_instalacion;
	}

	@Override
	public String toString() {
		return "InstalacionDeportiva: tipo_instalacion= " + tipo_instalacion + ", superficieEdificio= "
				+ getSuperficieEdificio() ;
	}

	
	
}
