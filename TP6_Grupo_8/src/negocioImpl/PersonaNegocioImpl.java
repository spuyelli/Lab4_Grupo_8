package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		Boolean estado;
		estado = pdao.insert(persona);
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni() != "" ) 
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}

	@Override
	public boolean update(Persona persona) {
		boolean estado=false;
		if(persona.getDni() != "" ) 
		{
			estado=pdao.update(persona);
		}
		return estado;
	}

	@Override
	public Persona select(String dni) {
		return pdao.select(dni);
	}

}
