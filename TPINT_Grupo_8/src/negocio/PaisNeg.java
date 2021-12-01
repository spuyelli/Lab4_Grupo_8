package negocio;

import java.util.ArrayList;
import entidades.Pais;

public interface PaisNeg {

	public ArrayList<Pais> listarPaises();
	public Pais select(int id);
}
