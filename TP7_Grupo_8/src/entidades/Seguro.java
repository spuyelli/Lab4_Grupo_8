package entidades;

public class Seguro {
	
	private int IdSeguro;
	private String Descripcion;
	private TipoSeguro tipoSeguro;
	private float CostoContratacion;
	private float CostoMaximoAsegurado;
	public int getIdSeguro() {
		return IdSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		IdSeguro = idSeguro;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}
	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}
	public float getCostoContratacion() {
		return CostoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		CostoContratacion = costoContratacion;
	}
	public float getCostoMaximoAsegurado() {
		return CostoMaximoAsegurado;
	}
	public void setCostoMaximoAsegurado(float costoMaximoAsegurado) {
		CostoMaximoAsegurado = costoMaximoAsegurado;
	}
	
}
