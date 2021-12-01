package dao;

import java.util.ArrayList;

import entidades.Provincia;

public interface ProvinciaDao {

	public ArrayList<Provincia> listarProvincias();
	public Provincia select(int id);
}
