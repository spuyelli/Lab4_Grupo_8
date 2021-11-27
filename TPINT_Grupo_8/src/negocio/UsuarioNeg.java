package negocio;

import entidades.Usuario;

public interface UsuarioNeg {
	
	public boolean insert(Usuario user);
	public Usuario select(int DNI);
	public boolean update(int DNI, boolean estado);
}
