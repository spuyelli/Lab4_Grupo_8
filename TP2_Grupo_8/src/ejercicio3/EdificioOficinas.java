package ejercicio3;

public class EdificioOficinas extends Edificio {
	private int cantidadOficinas;
	
	public int getCantidadOficinas() {
		return cantidadOficinas;
	}

	public void setCantidadOficinas(int cantidadOficinas) {
		this.cantidadOficinas = cantidadOficinas;
	}

	public EdificioOficinas(double sup, int cant) {
		super(sup);
		this.cantidadOficinas=cant;
		
	}

	@Override
	public String toString() {
		return "Edificio Oficinas:  cantidadOficinas= " + cantidadOficinas + ", superficieEdificio= "
				+ getSuperficieEdificio() ;
	}

	
	
}
