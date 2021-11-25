	package entidades;

import dao.SeguroDao;
import daoImpl.SeguroDaoImpl;
import daoImpl.TipoSeguroDaoImpl;

public class Seguro {
	
	private int IdSeguro;
	private String Descripcion;
	private int tipoSeguro;
	private float CostoContratacion;
	private float CostoMaximoAsegurado;
		
	public Seguro(int idSeguro, String descripcion, int tipoSeguro, float costoContratacion,
			float costoMaximoAsegurado) {
		this.IdSeguro = idSeguro;
		this.Descripcion = descripcion;
		this.tipoSeguro = tipoSeguro;
		this.CostoContratacion = costoContratacion;
		this.CostoMaximoAsegurado = costoMaximoAsegurado;
	}
	
	public Seguro()
    {
        SeguroDao data = new SeguroDaoImpl();
		this.IdSeguro = data.getLastID() + 1;
		this.Descripcion = "";
		this.tipoSeguro = 0;
		this.CostoContratacion = 0;
		this.CostoMaximoAsegurado = 0;
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

	public int getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(int tipoSeguro) {
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
		return "ID= " + IdSeguro + ", Descripción= " + Descripcion + ", Tipo de Seguro= ["
				+ getFullTipoSeguro(tipoSeguro).toString()
				+ "], Costo de Contratacion= $" + CostoContratacion + ", Costo Máximo Asegurado= $" + CostoMaximoAsegurado;
	}
	
	public TipoSeguro getFullTipoSeguro(int idTipoSeguro) {
		TipoSeguro tSeguro = new TipoSeguroDaoImpl().select(idTipoSeguro);
		return tSeguro;
	}

}
