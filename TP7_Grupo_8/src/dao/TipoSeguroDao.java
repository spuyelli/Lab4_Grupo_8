package dao;

import java.util.List;
import entidades.TipoSeguro;

public interface TipoSeguroDao {

	public TipoSeguro select(int tipoSeguro);
	public List<TipoSeguro> readAll();
}
