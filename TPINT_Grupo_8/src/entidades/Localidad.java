package entidades;

public class Localidad {
	private int idLocalidad;
	private String descripcion;
	private Provincia provincia;
	
	public Localidad() {
	}
	
	public Localidad(int idLocalidad, Provincia provincia) {
		super();
		this.idLocalidad = idLocalidad;
		this.provincia = provincia;
	}
	public Localidad(int idLocalidad) {
		super();
		this.idLocalidad = idLocalidad;
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
		return provincia;
	}
	public void setIdProvincia(Provincia idProvincia) {
		this.provincia = idProvincia;
	}
}
