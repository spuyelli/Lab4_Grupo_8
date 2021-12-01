package negocio;

import java.util.ArrayList;
import entidades.Localidad;

public interface LocalidadNeg {

	public ArrayList<Localidad> listarLocalidades();
	public Localidad select(int id);
}
