package negocio;

import java.util.ArrayList;

import entidades.Docente;

public interface DocenteNeg {
	public ArrayList<Docente> listarDocentes();
	public Docente BuscarDocente(int dni);
	public boolean ModificaDocente(Docente doc); 
}
