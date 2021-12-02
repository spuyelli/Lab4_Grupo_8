package dao;

import java.util.List;

import entidades.Docente;


public interface DocenteDao {
	
	public boolean insert ();
	public List<Docente> readAll();
	public boolean agregarDocente(Docente docente);
	public boolean eliminarDocente(int dni);

    public Docente BuscarDocente(int dni);
    public boolean ModificarDocente(Docente doc);
}
