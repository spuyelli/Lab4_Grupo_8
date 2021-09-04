package ejercicio2;

import java.util.Date;

public class ProductoCongelado extends Producto{
	
	private static int TemperaturaCongelacion;
	
	
	public ProductoCongelado(int TemperaturaCongelacion, int numeroLote, Date fechaCaducidad)
	{
		super(numeroLote, fechaCaducidad);
		ProductoCongelado.TemperaturaCongelacion = TemperaturaCongelacion;
	}


	public int getTemperaturaCongelacion() {
		return TemperaturaCongelacion;
	}


	public void setTemperaturaCongelacion(int temperaturaCongelacion) {
		TemperaturaCongelacion = temperaturaCongelacion;
	}


	@Override
	public String toString() {
		return "Es un Producto Congelado y su temperatura de Congelacion es: " + getTemperaturaCongelacion() + " y su numero de Lote es: "
				+ getNumeroLote() + ", su fecha de caducidad es " + getFechaCaducidad();
	}
	
}
