package ejercicio2;

public class ProductoFresco extends Producto {
	
	private static Date FechaEnvasado;
	private static String PaisOrigen;
	
	
	public ProductoFresco(Date FechaEnvasado, String PaisOrigen, int numeroLote, Date fechaCaducidad)
	{
		super(numeroLote, fechaCaducidad);
		ProductoFresco.FechaEnvasado = FechaEnvasado;
		ProductoFresco.PaisOrigen = PaisOrigen;
	}

	public Date getFechaEnvasado() {
		return FechaEnvasado;
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
