package dao;

import java.util.List;
import entidades.Seguro;

public interface SeguroDao {

	public boolean insert(Seguro seguro);
	public Seguro select(String IdSeguro);
	public boolean update(Seguro seguro);
	public boolean delete(Seguro seguro_a_eliminar);
	public List<Seguro> readAll();
}
