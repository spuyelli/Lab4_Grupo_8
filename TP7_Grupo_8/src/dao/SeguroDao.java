package dao;

import java.util.List;
import entidades.Seguro;

public interface SeguroDao {

	public boolean insert(Seguro seguro);
	public Seguro select(String IdSeguro);
	public List<Seguro> readAll();
	public List<Seguro> readAllTipoEspecifico(int idTipo);
	public int getLastID();

}
