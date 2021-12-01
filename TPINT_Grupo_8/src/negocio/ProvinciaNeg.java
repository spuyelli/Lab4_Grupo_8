package negocio;

import java.util.ArrayList;

import entidades.Provincia;

public interface ProvinciaNeg {

	public ArrayList<Provincia> listarProvincias();
	public Provincia select(int id);
}
