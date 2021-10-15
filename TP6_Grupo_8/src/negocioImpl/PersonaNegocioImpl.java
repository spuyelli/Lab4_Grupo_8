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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		// TODO Auto-generated method stub
		return false;
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

}
