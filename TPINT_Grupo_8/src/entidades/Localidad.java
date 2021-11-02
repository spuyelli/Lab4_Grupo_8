package entidades;

public class Localidad {
	private int idLocalidad;
	private int descripcion;
	private Provincia provincia;
	
	
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public int getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
}
