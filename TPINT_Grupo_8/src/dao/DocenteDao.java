package dao;

import java.util.List;

import entidades.Docente;


public interface DocenteDao {
	
	public boolean insert ();
	public List<Docente> readAll();

}
