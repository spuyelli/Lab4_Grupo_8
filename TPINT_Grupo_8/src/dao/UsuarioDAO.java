package dao;

import entidades.Usuario;

public interface UsuarioDAO {
	public boolean insert(Usuario user);
	public Usuario select(int DNI);
	public boolean update(int DNI, boolean estado);

}
