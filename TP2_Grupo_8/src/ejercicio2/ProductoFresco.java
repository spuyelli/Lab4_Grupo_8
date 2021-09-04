package ejercicio2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductoFresco extends Producto {
	
	private static Date FechaEnvasado;
	private static String PaisOrigen;
	
	
	public ProductoFresco(Date FechaEnvasado, String PaisOrigen, int numeroLote, Date fechaCaducidad)
	{
		super(numeroLote, fechaCaducidad);
		ProductoFresco.FechaEnvasado = FechaEnvasado;
		ProductoFresco.PaisOrigen = PaisOrigen;
	}

	public String getFechaEnvasado() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatoFecha.format(FechaEnvasado);
		}
		catch (Exception e) {
			System.out.println("Error al convertir fecha.");
		}
		return FechaEnvasado.toString();
	}

	public void setFechaEnvasado(Date fechaEnvasado) {
		FechaEnvasado = fechaEnvasado;
	}

	public String getPaisOrigen() {
		return PaisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		PaisOrigen = paisOrigen;
	}
	@Override
	public String toString() {
		return "Es un Producto Fresco y su fecha de envasado es: " + getFechaEnvasado() + ", su pais de origen es: " + getPaisOrigen()
				+ ", su numero de lote es " + getNumeroLote() + ", su fecha de caducidad es " + getFechaCaducidad();
	}
	
}
