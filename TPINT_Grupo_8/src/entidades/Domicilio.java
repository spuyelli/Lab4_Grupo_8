package entidades;

public class Domicilio {
	private String calle_numero;
	private Localidad localidad;
	
	
	public String getCalle_Numero() {
		return calle_numero;
	}
	public void setCalle_Numero(String calle_numero) {
		this.calle_numero = calle_numero;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}