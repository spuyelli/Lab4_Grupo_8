package dao;

import java.util.ArrayList;

import entidades.Pais;

public interface PaisDao {

	public ArrayList<Pais> listarPaises();
	public Pais select(int id);	
}
