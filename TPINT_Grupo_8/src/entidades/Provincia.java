package entidades;

public class Provincia {
	private int idProvincia;
	private int descripcion;
	private Pais pais;
	
	
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public int getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
