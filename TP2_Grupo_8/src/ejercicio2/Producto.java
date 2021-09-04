package ejercicio2;

public class Producto {

	private int numeroLote;
	private Date fechaCaducidad;
	
	public Producto(int numeroLote, Date fechaCaducidad) {
		this.numeroLote = numeroLote;
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public String toString() {
		return "Es un Producto y su numero de Lote es: " + numeroLote + " y su fecha de Caducidad es: " + fechaCaducidad;
	}
	

}
