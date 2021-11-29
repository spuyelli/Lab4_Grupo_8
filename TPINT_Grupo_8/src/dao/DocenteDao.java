package dao;

import java.util.List;

import entidades.Docente;


public interface DocenteDao {
	
	public boolean insert ();
	public List<Docente> readAll();
	public boolean agregarDocente(Docente docente);

    public Docente BuscarDocente(int dni);
    public boolean ModificaDocente(Docente doc);
}
