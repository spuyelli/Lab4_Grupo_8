package entidades;

import dao.SeguroDao;
import daoImpl.SeguroDaoImpl;

public class Seguro {
	
	private int IdSeguro;
	private String Descripcion;
	private TipoSeguro tipoSeguro;
	private float CostoContratacion;
	private float CostoMaximoAsegurado;
		
		public Seguro(int idSeguro, String descripcion, TipoSeguro tipoSeguro, float costoContratacion,
			float costoMaximoAsegurado) {
		IdSeguro = idSeguro;
		Descripcion = descripcion;
		this.tipoSeguro = tipoSeguro;
		CostoContratacion = costoContratacion;
		CostoMaximoAsegurado = costoMaximoAsegurado;
	}
	
	public Seguro()
    {
        SeguroDao data = new SeguroDaoImpl();
        IdSeguro = data.getLastID() + 1;
        Descripcion = "";
        tipoSeguro = null;
        CostoContratacion = 0;
        CostoMaximoAsegurado = 0;
    }
	
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

	@Override
	public String toString() {
		return "ID= " + IdSeguro + ", Descripción= " + Descripcion + ", Tipo de Seguro= [" + tipoSeguro.toString()
				+ "], Costo de Contratacion= $" + CostoContratacion + ", Costo Máximo Asegurado= $" + CostoMaximoAsegurado;
	}
	
}
