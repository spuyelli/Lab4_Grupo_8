package entidades;

public class Localidad {
	private int idLocalidad;
	private String descripcion;
	private Provincia idProvincia;
	
	public Localidad() {
	}
	
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public Provincia getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Provincia idProvincia) {
		this.idProvincia = idProvincia;
	}
}
