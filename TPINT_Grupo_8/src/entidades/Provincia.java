package entidades;

public class Provincia {
	private int idProvincia;
	private String descripcion;
	private Pais idPais;
	
	public Provincia() {
	}
	
	public Provincia(int idProvincia) {
		this.setIdProvincia(idProvincia);
	}
	
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Pais getIdPais() {
		return idPais;
	}
	public void setIdPais(Pais idPais) {
		this.idPais = idPais;
	}
}
