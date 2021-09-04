package ejercicio2;

public class ProductoRefrigerado extends Producto {
	
	private static int CodigoSupervisionAlimentaria;

	
	public ProductoRefrigerado(int CodigoSupervisionAlimentaria, int numeroLote, Date fechaCaducidad)
	{
		super(numeroLote, fechaCaducidad);
		ProductoRefrigerado.CodigoSupervisionAlimentaria = CodigoSupervisionAlimentaria;
	}


	public int getCodigoSupervisionAlimentaria() {
		return CodigoSupervisionAlimentaria;
	}


	public void setCodigoSupervisionAlimentaria(int codigoSupervisionAlimentaria) {
		CodigoSupervisionAlimentaria = codigoSupervisionAlimentaria;
	}


	@Override
	public String toString() {
		return "Es un Producto Refrigerado su Codigo de Supervision Alimentaria es " + getCodigoSupervisionAlimentaria()
				+ ", su Numero de Lote es " + getNumeroLote() + ", su fecha de Caducidad es " + getFechaCaducidad();
	}
}
